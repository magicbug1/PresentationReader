package com.squarpoint.cegit.presentation

import java.io.FileNotFoundException

class PresentationReader(name: String = "") {
    val fileName: String = name
    fun openFile() {
        throw FileNotFoundException("Can not open $fileName")
    }
}

fun main(args: Array<String>) {
    val pReader = PresentationReader("test")

}