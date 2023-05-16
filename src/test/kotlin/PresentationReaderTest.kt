package com.squarpoint.cegit.presentation
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.FileNotFoundException

internal class PresentationReaderTest {
    private var pReader: PresentationReader = PresentationReader()

    @BeforeEach
    fun setUp() {
        pReader = PresentationReader()
    }

    @Test
    fun openFile_whenFileNotExists_throwsFileNotFoundException() {
        assertThrows<FileNotFoundException> {
            pReader.openFile()
        }
    }
    fun openFile_whenFileExists_doesNotThrowsFileNotFoundException() {
        assertThrows<FileNotFoundException> {
            pReader.openFile()
        }
    }
}
