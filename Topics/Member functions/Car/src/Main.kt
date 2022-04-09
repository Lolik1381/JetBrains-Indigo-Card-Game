class Car(val make: String, val year: Int) {

    var speed: Int = 0

    fun accelerate() {
        this.speed += 5
    }

    fun decelerate() {
        this.speed -= 5
        if (this.speed < 0) {
            this.speed = 0
        }
    }
}