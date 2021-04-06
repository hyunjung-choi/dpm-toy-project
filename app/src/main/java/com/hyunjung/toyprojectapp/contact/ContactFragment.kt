package com.hyunjung.toyprojectapp.contact

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.hyunjung.toyprojectapp.R
import com.hyunjung.toyprojectapp.adapter.ContactAdapter
import com.hyunjung.toyprojectapp.databinding.FragmentContactBinding
import org.json.JSONObject
import java.io.FileNotFoundException

class ContactFragment : Fragment() {

    lateinit var binding : FragmentContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactBinding.inflate(inflater, container,false)

        val contactData : MutableList<Contact> = loadContactData()
        var contactAdapter = ContactAdapter()
        contactAdapter.contactData = contactData
        binding.contactRv.adapter = contactAdapter
        binding.contactRv.layoutManager = LinearLayoutManager(this.context)

        return binding.root
    }

    fun loadContactData() : MutableList<Contact>{
        val data: MutableList<Contact> = mutableListOf()
        val gson = Gson()
        val testString: String

        try {
            val assetManager = resources.assets
            val inputStream = assetManager.open("Sample_List.json")
            testString = inputStream
                .bufferedReader()
                .use {it.readText()}

            val jObject = JSONObject(testString)
            val jArray = jObject.getJSONArray("data")

            for(i in 0 until jArray.length()){
                val contactObj = gson.fromJson(jArray.get(i).toString(), Contact::class.java)
                data.add(contactObj)
            }

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

        return data
    }

}