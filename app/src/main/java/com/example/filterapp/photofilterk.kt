package com.example.filterapp

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.renderscript.*
import android.support.annotation.RequiresApi

@SuppressLint("NewApi")
 class PhotoFilterK {

    lateinit var renderScript: RenderScript
     lateinit var inputAllocation: Allocation
     lateinit var outputAllocation: Allocation
     lateinit var outBitmap: Bitmap

    //filter1
    fun one(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {

        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix1 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix1.setColorMatrix(
            android.renderscript.Matrix4f(
                floatArrayOf(
                    (-0.32f/0.5f)*seeker,
                    (-0.32f/0.5f)*seeker,
                    (-0.32f/0.5f)*seeker,
                    1.0f,

                    (-0.59f/0.5f)*seeker,
                    (-0.59f/0.5f)*seeker,
                    (-0.59f/0.5f)*seeker,
                    1.0f,

                    (-0.11f/0.5f)*seeker,
                    (-0.11f/0.5f)*seeker,
                    (-0.11f/0.5f)*seeker,
                    1.0f,

                    1.0f,
                    1.0f,
                    1.0f,
                    1.0f

                )
            )
        )
        colorMatrix1.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter2
    @SuppressLint("NewApi")
    fun two(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix2 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix2.setGreyscale()
        colorMatrix2.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter3
    @SuppressLint("NewApi")
    fun three(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix3 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix3.setColorMatrix(
            Matrix4f(
                floatArrayOf(
                    (0f/0.5f)*seeker,
                    (0f/0.5f)*seeker,
                    (0f/0.5f)*seeker,
                    0f,
                    (0f/0.5f)*seeker,
                    (0.78f/0.5f)*seeker,
                    (0f/0.5f)*seeker,
                    0f,
                    (0f/0.5f)*seeker,
                    (0f/0.5f)*seeker,
                    (1f/0.5f)*seeker,
                    0f,
                    0f,
                    0f,
                    0f,
                    1f
                )
            )
        )
        colorMatrix3.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter4
    @SuppressLint("NewApi")
    fun four(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix4 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix4.setColorMatrix(
            android.renderscript.Matrix4f(
                floatArrayOf(
                    (0.3f/0.5f)*seeker,
                    (0f/0.5f)*seeker,
                    (0f/0.5f)*seeker,
                    0f,
                    (0f/0.5f)*seeker,
                    (0.65f/0.5f)*seeker,
                    (0f/0.5f)*seeker,
                    0f,
                    (0f/0.5f)*seeker,
                    (0f/0.5f)*seeker,
                    (0.49f/0.5f)*seeker,
                    0f,
                    0f,
                    0f,
                    0f,
                    1f
                )
            )
        )
        colorMatrix4.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter5
    @SuppressLint("NewApi")
    fun five(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix5 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix5.setColorMatrix(
            android.renderscript.Matrix4f(
                floatArrayOf(
                    (-0.359705309629158f/0.5f)*seeker,
                    (0.377252728606377f/0.5f)*seeker,
                    (0.663841667303255f/0.5f)*seeker,
                    0f,
                    (1.56680818833214f/0.5f)*seeker,
                    (0.456668209492391f/0.5f)*seeker,
                    (1.12613917506705f/0.5f)*seeker,
                    0f,
                    (-0.147102878702981f/0.5f)*seeker,
                    (0.226079061901232f/0.5f)*seeker,
                    (-0.729980842370303f/0.5f)*seeker,
                    0f,
                    0f,
                    0f,
                    0f,
                    1f
                )
            )
        )
        colorMatrix5.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter6
    @SuppressLint("NewApi")
    fun six(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix6 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix6.setColorMatrix(
            android.renderscript.Matrix4f(
                floatArrayOf(
                        (1.2f/0.5f)*seeker,
                        (0.1f/0.5f)*seeker,
                        (0.2f/0.5f)*seeker,
                        0.7f,

                        (0.7f/0.5f)*seeker,
                        (1f/0.5f)*seeker,
                        (0f/0.5f)*seeker,
                        -0.5f,

                        (-0.7f/0.5f)*seeker,
                        (0.2f/0.5f)*seeker,
                        (0.5f/0.5f)*seeker,
                        1.3f,

                        0f,
                        -0.1f,
                        0f,
                        0.9f
                )
            )
        )
        colorMatrix6.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter7
    fun seven(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix7 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix7.setColorMatrix(
            android.renderscript.Matrix4f(
                floatArrayOf(
                        (1.22994596833595f/0.5f)*seeker,
                        (0.0209523774645382f/0.5f)*seeker,
                        (0.383244054685119f/0.5f)*seeker,
                        0f,

                        (0.450138899443543f/0.5f)*seeker,
                        (1.18737418804171f/0.5f)*seeker,
                        (-0.106933249401007f/0.5f)*seeker,
                        0f - 0.340084867779496f,

                        (0.131673434493755f/0.5f)*seeker,
                        (1.06368919471589f/0.5f)*seeker,
                        (0f/0.5f)*seeker,
                        0f,

                        0f,
                        0f,
                        11.91f,
                        11.91f,
                        11.91f,
                        0f
                )
            )
        )
        colorMatrix7.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter8
    @SuppressLint("NewApi")
    fun eight(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix8 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix8.setColorMatrix(
            android.renderscript.Matrix4f(
                floatArrayOf(
                        (1.44f/0.5f)*seeker,
                        (0f/0.5f)*seeker,
                        (0f/0.5f)*seeker,
                        0f,
                        (0f/0.5f)*seeker,
                        (1.44f/0.5f)*seeker,
                        (0f/0.5f)*seeker,
                         0f,
                        (0f/0.5f)*seeker,
                        (0f/0.5f)*seeker,
                        (1.44f/0.5f)*seeker,
                        0f,
                        0f,
                        0f,
                        0f,
                        1f
                )
            )
        )
        colorMatrix8.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter9
    @SuppressLint("NewApi")
    fun nine(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix9 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix9.setColorMatrix(
            android.renderscript.Matrix4f(
                floatArrayOf(
                    -2f,
                    -1f,
                    1f,
                    -2f,
                    0f,
                    -2f,
                    0f,
                    1f,
                    0f,
                    0f,
                    -1f,
                    1f,
                    0f,
                    0f,
                    0f,
                    1f
                )
            )
        )
        colorMatrix9.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter10
    @SuppressLint("NewApi")
    fun ten(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix10 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix10.setColorMatrix(
            android.renderscript.Matrix4f(
                floatArrayOf(
                    1f,
                    0f,
                    0.1f,
                    -0.1f,
                    0f,
                    1f,
                    0.2f,
                    0f,
                    0f,
                    0f,
                    1.3f,
                    0f,
                    0f,
                    0f,
                    0f,
                    1f
                )
            )
        )
        colorMatrix10.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter11
    @SuppressLint("NewApi")
    fun eleven(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix11 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix11.setColorMatrix(
            android.renderscript.Matrix4f(
                floatArrayOf(
                    1.72814708519562f,
                    -0.412104992562475f,
                    0.541145007437525f,
                    0f,
                    0.289378264402959f,
                    1.18835534216106f,
                    -1.17637173559704f,
                    0f,
                    -1.01752534959858f,
                    0.223749650401417f,
                    1.63522672815952f,
                    0f,
                    0f,
                    0f,
                    0f,
                    1f
                )
            )
        )
        colorMatrix11.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter12
    @SuppressLint("NewApi")
    fun twelve(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix12 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix12.setColorMatrix(
            android.renderscript.Matrix4f(
                floatArrayOf(
                    .309f,
                    .409f,
                    .309f,
                    0f,
                    .609f,
                    .309f,
                    .409f,
                    0f,
                    0.42f,
                    .42f,
                    .2f,
                    0f,
                    0f,
                    0f,
                    0f,
                    1f
                )
            )
        )
        colorMatrix12.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter13
    fun thirteen(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val convolve1 = ScriptIntrinsicConvolve3x3.create(renderScript, Element.U8_4(renderScript))
        convolve1.setInput(inputAllocation)
        convolve1.setCoefficients(floatArrayOf((-2f/0.5f)*seeker,(-1f/0.5f)*seeker, (0f/0.5f)*seeker, -1f, (1f/0.5f)*seeker, (1f/0.5f)*seeker, (0f/0.5f)*seeker, 1f, 2f))
        convolve1.forEach(outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter14
    fun fourteen(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val convolve2 = ScriptIntrinsicConvolve3x3.create(renderScript, Element.U8_4(renderScript))
        convolve2.setInput(inputAllocation)
        convolve2.setCoefficients(floatArrayOf(.2f, .3f, .2f, .1f, .1f, .1f, .2f, .3f, .2f))
        convolve2.forEach(outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter15
    fun fifteen(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix13 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix13.setColorMatrix(
            android.renderscript.Matrix4f(
                floatArrayOf(

                        (2.10279132254252f/0.5f)*seeker,
                        (-0.298212630531356f/0.5f)*seeker,
                        (0.42128146417712f/0.5f)*seeker,
                        0f,
                        (0.222897572029231f/0.5f)*seeker,
                        (1.68701190285368f/0.5f)*seeker,
                        (-0.883421304780577f/0.5f)*seeker,
                        0f,
                        (-0.765688894571747f/0.5f)*seeker,
                        (0.171200727677677f/0.5f)*seeker,
                        (2.02213984060346f/0.5f)*seeker,
                        0f,
                        0f,
                        0f,
                        0f,
                        1f
                )
            )
        )
        colorMatrix13.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }

    //filter16
    fun sixteen(context: Context, bitmap: Bitmap,seeker:Float): Bitmap {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val colorMatrix14 = ScriptIntrinsicColorMatrix.create(renderScript, Element.U8_4(renderScript))
        colorMatrix14.setColorMatrix(
            android.renderscript.Matrix4f(
                floatArrayOf(

                        (1.27488526960083f/0.5f)*seeker,
                        (-0.228511311848763f/0.5f)*seeker,
                        (0.441088688151237f/0.5f)*seeker,
                        0f,
                        (0.323664244263542f/0.5f)*seeker,
                        (0.955140825713134f/0.5f)*seeker,
                        (-0.705935755736458f/0.5f)*seeker,
                        0f,
                        (-0.698549513864371f/0.5f)*seeker,
                        (0.173370486135629f/0.5f)*seeker,
                        (1.16484706758522f/0.5f)*seeker,
                        0f,
                        0f,
                        0f,
                        0f,
                        1f
                )
            )
        )
        colorMatrix14.forEach(inputAllocation, outputAllocation)
        outputAllocation.copyTo(outBitmap)
        return outBitmap
    }
}