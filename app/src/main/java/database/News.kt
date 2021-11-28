package database

import com.google.firebase.firestore.Exclude

class News {
    var title: String? = ""
    var content: String? = ""
    var views: String? = "0"
    var publisher: String? = ""
    var imageURL: String? = ""

    @get:Exclude
    @set:Exclude
    var key: String? = ""

    override fun toString(): String {
        return title!!
    }

}

