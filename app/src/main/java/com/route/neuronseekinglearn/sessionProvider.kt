package com.route.neuronseekinglearn

import com.route.neuronseekinglearn.model.User

object sessionProvider {
    var user: User? = null
        set(value) {
            field = value
            println("sessionProvider.user set to: $value")
        }
        get() {
            println("sessionProvider.user accessed: $field")
            return field
        }
}
