package com.squarpoint.cegit.presentation

import java.io.EOFException
import java.io.File
import java.io.FileInputStream


class PresentationReader(name: String = "") {
    var fileName: String = name
    var fileInputStream: FileInputStream? = null
    fun openFile() {
        fileInputStream = File(fileName).inputStream()
    }

    fun readChar(): Char {
        if (fileInputStream == null) {
            println("File inputstream is invalid")
            throw EOFException("Invalid stream [$fileName]")
        }
        return fileInputStream!!.read().toChar()
    }
}

fun main() {
    val pReader = PresentationReader("test")
    println(pReader.readChar())
}