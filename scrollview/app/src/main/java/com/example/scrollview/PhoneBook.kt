package com.example.scrollview

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class PhoneBook {
    private val phoneBookFile = "phone_book.ser"
    private val phoneBook = HashMap<String, Customer>()

    fun addContact(name: String, sex: String, ldate: String, kdate: String, time: String, tel: String, memo: String) {
        val cus:Customer? = null
        cus?.name = name
        cus?.sex = sex
        cus?.ldate = ldate
        cus?.kdate = kdate
        cus?.time = time
        cus?.tel = tel
        cus?.memo = memo

        phoneBook[name] = cus as Customer
        savePhoneBook()
    }

    fun removeContact(name: String) {
        phoneBook.remove(name)
        savePhoneBook()
    }

    fun getContact(name: String): Customer? {
        return phoneBook[name]
    }

    fun getContacts(): List<String> {
        return phoneBook.keys.toList()
    }

    fun savePhoneBook() {
        val file = File(phoneBookFile)
        val outputStream = FileOutputStream(file)
        val objectOutputStream = ObjectOutputStream(outputStream)
        objectOutputStream.writeObject(phoneBook)
        objectOutputStream.close()
        outputStream.close()
    }

    fun loadPhoneBook() {
        val file = File(phoneBookFile)
        if (!file.exists()) {
            return
        }
        val inputStream = FileInputStream(file)
        val objectInputStream = ObjectInputStream(inputStream)
        @Suppress("UNCHECKED_CAST")
        phoneBook.putAll(objectInputStream.readObject() as HashMap<String, Customer>)
        objectInputStream.close()
        inputStream.close()
    }
}