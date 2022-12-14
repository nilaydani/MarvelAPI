package com.lbg.demo.feature_marvel_heroes.data.remote.data_source.mapper.characters

import com.lbg.demo.feature_marvel_heroes.data.remote.data_source.mapper.characters.mocks.CharactersMocks
import com.lbg.demo.marvel_heroes.data.remote.data_source.mapper.characters.CharacterResponseMapper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.StrictStubs::class)
class CharacterResponseMapperTest {

    private val charactersMocks = CharactersMocks()

    @Test
    fun `Transform CharacterResponseDto to CharacterResponseModel`() {
        val result = CharacterResponseMapper(charactersMocks.getDataMapper()).transform(
            charactersMocks.getCharacterResponseDto()
        )

        with(charactersMocks.getCharacterResponseModel()) {
            Assert.assertEquals(result.attributionHTML, attributionHTML)
            Assert.assertEquals(result.attributionText, attributionText)
            Assert.assertEquals(result.code, code)
            Assert.assertEquals(result.copyright, copyright)
            Assert.assertEquals(result.dataModel.count, dataModel.count)
            Assert.assertEquals(result.dataModel.limit, dataModel.limit)
            Assert.assertEquals(result.dataModel.offset, dataModel.offset)

            result.dataModel.resultModels.forEachIndexed { index, it ->
                Assert.assertTrue(
                    it.comicsModel.available ==
                            dataModel.resultModels[index].comicsModel.available
                )
                Assert.assertEquals(
                    it.comicsModel.available,
                    dataModel.resultModels[index].comicsModel.available
                )
            }
        }
    }
}