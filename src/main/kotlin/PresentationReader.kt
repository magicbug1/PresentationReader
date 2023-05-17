package com.squarpoint.cegit.presentation

import java.io.File
import java.io.FileInputStream
import java.nio.ByteBuffer


class PresentationReader(name: String = "") {
    var fileName: String = name
    var fileInputStream: FileInputStream? = null
    private var fileContentBuffer: ByteArray? = null
    fun getData() {
        fileInputStream = File(fileName).inputStream()
        fileContentBuffer = fileInputStream!!.readAllBytes()
        fileInputStream!!.close()
    }

    fun readByte(): UByte {
        return fileContentBuffer!![0].toUByte()
    }

    fun getObjectSize(): Long {
        val sizeArray = byteArrayOf(0,0,0,0) + fileContentBuffer!!.copyOfRange(0, 4)
        val rslt = ByteBuffer.wrap(sizeArray).long
        return rslt
    }
}

fun main() {
   val pReader = PresentationReader("src/main/resources/ASP_GM_PLANTILLAS_VARIABLES.presentation.hex")
    pReader.getData()
    val size = pReader.getObjectSize()
    println("$size --> 0x${String.format("%X", size)}")
}