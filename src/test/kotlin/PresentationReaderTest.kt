package com.squarpoint.cegit.presentation

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.io.FileNotFoundException

internal class PresentationReaderTest {
    private var pReader: PresentationReader = PresentationReader()
    private val testFileName = "src/test/resources/ASP_GM_PLANTILLAS_VARIABLES.presentation.hex"

    @BeforeEach
    fun setUp() {
        pReader = PresentationReader(testFileName)
    }

    @Test
    fun openFile_whenFileNotExists_throwsFileNotFoundException() {
        assertThrows<FileNotFoundException> {
            pReader.fileName ="Not a file"
            pReader.openFile()
        }
    }

    @Test
    fun openFile_whenFileExists_doesNotThrowException() {
        assertDoesNotThrow {
            pReader.openFile()
        }
    }

    @Test
    fun getChar_returnsNextChar() {
        pReader.openFile()
        val c = pReader.readChar()
        println("c = [$c]")
        assert('0' == c)
    }
}
