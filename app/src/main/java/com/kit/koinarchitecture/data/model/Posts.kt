package com.kit.koinarchitecture.data.model

class Posts(
    val id: Long,
    val title: String,
    val body: String
) {
    override fun toString(): String {
        return "Repo(id=$id, name='$title', description='$body')"
    }
}