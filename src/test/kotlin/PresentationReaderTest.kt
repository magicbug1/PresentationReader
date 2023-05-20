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
        pReader.getData()
    }

    @Test
    fun openFile_whenFileNotExists_throwsFileNotFoundException() {
        assertThrows<FileNotFoundException> {
            pReader.fileName = "Not a file"
            pReader.getData()
        }
    }

    @Test
    fun openFile_whenFileExists_doesNotThrowException() {
        assertDoesNotThrow {
            pReader.getData()
        }
    }

    @Test
    fun readChar_returnsNextChar() {
        val c = pReader.readByte()
        println("c = [$c]")
        assert('0'.code == c.toInt())
    }

    @Test
    fun readInt_returnsNextInt() {
        pReader.getObjectSize()
    }

    @Test
    fun getPresentationSize_getsCorrectValue() {
        pReader.readShort()
        val objectSize = pReader.readShort()
        assert(objectSize.toInt() + 4 == pReader.getPresentationSize())
    }

    @Test
    fun readShort_readsShortAsTwoBytes() {
        val shortRead = pReader.readShort()
        assert(shortRead.toInt() == 0x3082)
    }

    @Test
    fun readShort_readsNextValueToo() {
        val shortRead = pReader.readShort()
        val nextShortRead = pReader.readShort()
        assert(shortRead != nextShortRead)
    }
}
