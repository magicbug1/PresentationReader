package com.squarpoint.cegit.presentation

import java.io.File
import java.io.FileInputStream
import java.nio.ByteBuffer


class PresentationReader(name: String = "") {
    var fileName: String = name
    var fileInputStream: FileInputStream? = null
    private var fileContentBuffer: ByteArray? = null
    private var bufferIndex: Int = 0
    fun getData() {
        fileInputStream = File(fileName).inputStream()
        fileContentBuffer = fileInputStream!!.readAllBytes()
        fileInputStream!!.close()
    }

    fun readByte(): UByte {
        return fileContentBuffer!![bufferIndex].toUByte()
    }

    fun readShort(): Short {
        bufferIndex += 2
        return ByteBuffer.wrap(fileContentBuffer!!.copyOfRange(bufferIndex - 2, bufferIndex)).short
    }

    fun getObjectSize(): Long {
        val sizeArray = byteArrayOf(0, 0, 0, 0, 0, 0) + fileContentBuffer!!.copyOfRange(2, 4)
        val rslt = ByteBuffer.wrap(sizeArray).long
        return rslt
    }

    fun getPresentationSize() = fileContentBuffer!!.size
}

fun main() {
    val pReader = PresentationReader("src/main/resources/ASP_GM_PLANTILLAS_VARIABLES.presentation.hex")
    pReader.getData()
    /*pReader.
    println("$size --> 0x${String.format("%X", size)}")*/
    val size = pReader.getObjectSize()
    println("$size --> 0x${String.format("%X", size)}")
    println("Presentation object size = ${pReader.getPresentationSize()}")
}