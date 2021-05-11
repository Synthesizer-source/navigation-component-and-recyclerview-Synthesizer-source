package school.cactus.succulentshop

import org.junit.Test
import school.cactus.succulentshop.product.list.ProductStore
import org.junit.Assert.*

class RelatedProductsUnitTest {

    private val data = ProductStore()

    @Test
    fun test(){

        assertEquals(5, data.relatedProducts(1).size)
        assertEquals(data.products.size - 1, data.relatedProducts(1,100).size)
        assertEquals(1,data.relatedProducts(1,1).size)

        assertEquals(false, data.relatedProducts(1).any { it.id == 1 })
        assertEquals(true, data.relatedProducts(1).any { it.id != 1 })

        assertEquals(data.products.filter { it.id != 1 }.subList(0,5), data.relatedProducts(1))

    }
}