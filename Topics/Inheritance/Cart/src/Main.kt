fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = Product.newProduct(productType, price)
    println(product.totalPrice())
}

open class Product(val price: Int) {

    companion object {

        fun newProduct(productType: String, price: Int): Product {
            return when (ProductType.valueOf(productType.uppercase())) {
                ProductType.HEADPHONES -> HeadphonesProduct(price)
                ProductType.LAPTOP -> LaptopProduct(price)
                ProductType.SMARTPHONE -> SmartphoneProduct(price)
                ProductType.TV -> TvProduct(price)
            }
        }

        enum class ProductType {
            HEADPHONES, SMARTPHONE, TV, LAPTOP
        }
    }

    open fun totalPrice(): Int {
        return price
    }
}

class HeadphonesProduct(price: Int) : Product(price) {
    companion object {
        const val tax: Double = 0.11
    }

    override fun totalPrice(): Int {
        return (price + price * tax).toInt()
    }
}

class SmartphoneProduct(price: Int) : Product(price) {
    companion object {
        const val tax: Double = 0.15
    }

    override fun totalPrice(): Int {
        return (price + price * tax).toInt()
    }
}

class TvProduct(price: Int) : Product(price) {
    companion object {
        const val tax: Double = 0.17
    }

    override fun totalPrice(): Int {
        return (price + price * tax).toInt()
    }
}

class LaptopProduct(price: Int) : Product(price) {
    companion object {
        const val tax: Double = 0.19
    }

    override fun totalPrice(): Int {
        return (price + price * tax).toInt()
    }
}