package com.example.filterapp

import android.Manifest
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Path
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.data
import android.R.attr.data
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Environment
import java.nio.channels.FileChannel
import android.os.ParcelFileDescriptor
import android.util.Base64
import com.squareup.picasso.Picasso
import java.io.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : Activity() {

    var imgUri: Uri=Uri.EMPTY
    lateinit var FilterList:ArrayList<filter>
    lateinit var gallery: Button
    lateinit  var image: Bitmap
    lateinit  var original: ImageView
    lateinit var picturePath: String
    lateinit var thumbnail:Bitmap
    var photoFilter = PhotoFilterK()
    var currentfilter:Int=0

    private var imageCaptureUri: Uri? = null

    private var file: File? = null
    private var sourceFile: File? = null
    private var destFile: File? = null

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FilterList= arrayListOf()

        filterlist.adapter=FilterAdapter(this,FilterList,::applyfilter)
        filterlist.layoutManager = LinearLayoutManager( this, LinearLayout.HORIZONTAL,false)

        seekBar.setOnSeekBarChangeListener(seekBarChangeListener)

        original = findViewById(R.id.original_image) as ImageView

        gallery = findViewById(R.id.gallery) as Button
        gallery.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(
                        Manifest.permission.CAMERA
                ),2)}
            val i = Intent(Intent.ACTION_PICK)
            i.setType("image/*")
            startActivityForResult(i,1);
        }
        save_image.setOnClickListener {
            SaveImage(FilterList[currentfilter].image)
            Toast.makeText(this,"Image Saved!",Toast.LENGTH_LONG).show()
        }
    }
    fun applyfilter( index:Int){
        currentfilter=index
        thumbnail = BitmapFactory.decodeFile(picturePath)
        when (index) {
            0 -> original_image.setImageBitmap(FilterList[0].image)
            1 -> original_image.setImageBitmap(photoFilter.one(this, thumbnail,0.5f))
            2 -> original_image.setImageBitmap(photoFilter.two(this, thumbnail,0.5f))
            3 -> original_image.setImageBitmap(photoFilter.three(this, thumbnail,0.5f))
            4 -> original_image.setImageBitmap(photoFilter.four(this, thumbnail,0.5f))
            5 -> original_image.setImageBitmap(photoFilter.five(this, thumbnail,0.5f))
            6 -> original_image.setImageBitmap(photoFilter.six(this, thumbnail,0.5f))
            7 -> original_image.setImageBitmap(photoFilter.seven(this, thumbnail,0.5f))
            8 -> original_image.setImageBitmap(photoFilter.eight(this, thumbnail,0.5f))
            9 -> original_image.setImageBitmap(photoFilter.nine(this, thumbnail,0.5f))
            10 -> original_image.setImageBitmap(photoFilter.ten(this, thumbnail,0.5f))
            11-> original_image.setImageBitmap(photoFilter.eleven(this, thumbnail,0.5f))
            12-> original_image.setImageBitmap(photoFilter.twelve(this, thumbnail,0.5f))
            13-> original_image.setImageBitmap(photoFilter.thirteen(this, thumbnail,0.5f))
            14-> original_image.setImageBitmap(photoFilter.fourteen(this, thumbnail,0.5f))
            15-> original_image.setImageBitmap(photoFilter.fifteen(this, thumbnail,0.5f))
            16-> original_image.setImageBitmap(photoFilter.sixteen(this, thumbnail,0.5f))
            else -> println("Number too high")
        }

    }
    fun SaveImage(finalBitmap:Bitmap ) {
        var root:String  = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES).toString();
        var myDir =File(root + "/saved_images");
        myDir.mkdirs();
        var generator = Random();
        Log.e("hahaha","generated")
        var n = 10000;
        n = generator.nextInt(n)
        Log.e("hahaha","generated")
        var fname = "Image-"+ n +".jpg";
        var file = File (myDir, fname)
        Log.e("hahaha","f created")
        try {
            var out:FileOutputStream =  FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)
            out.flush()
            out.close()
        } catch ( e:Exception) {
            e.printStackTrace();
        }

        MediaScannerConnection.scanFile(this, arrayOf(file.toString()), null,
                MediaScannerConnection.OnScanCompletedListener() { s: String, uri: Uri ->
                    fun onScanCompleted(path:String ,  uri:Uri) {

        }
    });
}
    fun storeImage(image:Bitmap ) {
    var pictureFile:File?  = getOutputMediaFile();
    if (pictureFile == null) {
        Log.d("hahaha", "Error creating media file, check storage permissions: ");// e.getMessage());
        return;
    }
    try {
        var fos:FileOutputStream  =  FileOutputStream(pictureFile);
        image.compress(Bitmap.CompressFormat.PNG, 90, fos);
        fos.close();
    } catch (e:FileNotFoundException ) {
        Log.d("hahaha", "File not found: " + e.message);
    } catch ( e:IOException) {
        Log.d("hahaha", "Error accessing file: " + e.message);
    }
}
    fun getOutputMediaFile():File?{
        val mediaStorageDir:File = File(Environment.getExternalStorageDirectory().toString()
            + "/Android/data/"
            + getApplicationContext().getPackageName()
            + "/Files");

        if (! mediaStorageDir.exists()){
        if (! mediaStorageDir.mkdirs()){
            return null;
            }
        }

        var timeStamp:String =  SimpleDateFormat("ddMMyyyy_HHmm").format( Date())
        var mediaFile:File
        var mImageName:String="MI_"+ timeStamp +".jpg"
        mediaFile =File(mediaStorageDir.getPath() + File.separator + mImageName)
        return mediaFile;
}
    fun filtermaster(thumbnail:Bitmap){
        FilterList.clear()
        var filterimage:Bitmap?=null

        FilterList.add(filter(0,"original",thumbnail))
        FilterList.add(filter(1,"original",photoFilter.one(this, thumbnail,0.5f)))
        filterimage=photoFilter.two(this, thumbnail,0.5f)
        FilterList.add(filter(2,"original",filterimage))
        filterimage=photoFilter.three(this, thumbnail,0.5f)
        FilterList.add(filter(3,"original",filterimage))
        filterimage=photoFilter.four(this, thumbnail,0.5f)
        FilterList.add(filter(4,"original",filterimage))
        filterimage=photoFilter.five(this, thumbnail,0.5f)
        FilterList.add(filter(5,"original",filterimage))
        filterimage=photoFilter.six(this, thumbnail,0.5f)
        FilterList.add(filter(6,"original",filterimage))
        filterimage=photoFilter.seven(this, thumbnail,0.5f)
        FilterList.add(filter(7,"original",filterimage))
        filterimage=photoFilter.eight(this, thumbnail,0.5f)
        FilterList.add(filter(8,"original",filterimage))
        filterimage=photoFilter.nine(this, thumbnail,0.5f)
        FilterList.add(filter(9,"original",filterimage))
        filterimage=photoFilter.ten(this, thumbnail,0.5f)
        FilterList.add(filter(10,"original",filterimage))
        FilterList.add(filter(11,"original",photoFilter.eleven(this, thumbnail,0.5f)))
        FilterList.add(filter(12,"hahaha",photoFilter.one(this, thumbnail,0.5f)))
        FilterList.add(filter(13,"origiwqeqq",photoFilter.thirteen(this, thumbnail,0.5f)))
        filterimage=photoFilter.fourteen(this, thumbnail,0.5f)
        FilterList.add(filter(14,"12456",filterimage))
        filterimage=photoFilter.fifteen(this, thumbnail,0.5f)
        FilterList.add(filter(15,"gsdgds",filterimage))
        filterimage=photoFilter.sixteen(this, thumbnail,0.5f)
        FilterList.add(filter(16,"32tet",filterimage))

    }


    var seekBarChangeListener: SeekBar.OnSeekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {

        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

            var photoFilter = PhotoFilterK()
            when (currentfilter-1) {
                0 -> original_image.setImageBitmap(photoFilter.one(this@MainActivity, thumbnail,progress/100f))
                1 -> original_image.setImageBitmap(photoFilter.two(this@MainActivity, thumbnail,progress/100f))
                2 -> original_image.setImageBitmap(photoFilter.three(this@MainActivity, thumbnail,progress/100f))
                3 -> original_image.setImageBitmap(photoFilter.four(this@MainActivity, thumbnail,progress/100f))
                4 -> original_image.setImageBitmap(photoFilter.five(this@MainActivity, thumbnail,progress/100f))
                5 -> original_image.setImageBitmap(photoFilter.six(this@MainActivity, thumbnail,progress/100f))
                6 -> original_image.setImageBitmap(photoFilter.seven(this@MainActivity, thumbnail,progress/100f))
                7 -> original_image.setImageBitmap(photoFilter.eight(this@MainActivity, thumbnail,progress/100f))
                8 -> original_image.setImageBitmap(photoFilter.nine(this@MainActivity, thumbnail,progress/100f))
                9 -> original_image.setImageBitmap(photoFilter.ten(this@MainActivity, thumbnail,progress/100f))
                10-> original_image.setImageBitmap(photoFilter.eleven(this@MainActivity, thumbnail,progress/100f))
                11-> original_image.setImageBitmap(photoFilter.twelve(this@MainActivity, thumbnail,progress/100f))
                12-> original_image.setImageBitmap(photoFilter.thirteen(this@MainActivity, thumbnail,progress/100f))
                13-> original_image.setImageBitmap(photoFilter.fourteen(this@MainActivity, thumbnail,progress/100f))
                14-> original_image.setImageBitmap(photoFilter.fifteen(this@MainActivity, thumbnail,progress/100f))
                15-> original_image.setImageBitmap(photoFilter.sixteen(this@MainActivity, thumbnail,progress/100f))

                else -> println("Number too high")
            }
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {
            // called when the user first touches the SeekBar
        }

        override fun onStopTrackingTouch(seekBar: SeekBar) {
            // called after the user finishes moving the SeekBar
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            val selectedImage = data.data
            val filePath = arrayOf(MediaStore.Images.Media.DATA)
            val c = contentResolver.query(selectedImage!!, filePath, null, null, null)
            c!!.moveToFirst()
            val columnIndex = c.getColumnIndex(filePath[0])
            picturePath = c.getString(columnIndex)
            c.close()
            image = (BitmapFactory.decodeFile(picturePath));
            original.setImageBitmap(image)
            filtermaster(image)

        }


    }



}