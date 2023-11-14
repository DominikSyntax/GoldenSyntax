import charakter.*


fun main() {

    val heroOne:Hero = NatureMutant("Hure",1000,100)
    val hurensohn :Endboss = Endboss("Hurensohn")
    var counter = 5

    do {
        absatz()
        chuckNorris(counter)
        absatz()
        counter+= 1
    }while (counter<10)


}















