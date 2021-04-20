package com.hyunjung.toyprojectapp

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.hyunjung.toyprojectapp.adapter.FragmentAdapter
import com.hyunjung.toyprojectapp.contact.ContactFragment
import com.hyunjung.toyprojectapp.databinding.ActivityMainBinding
import com.hyunjung.toyprojectapp.gallery.GalleryFragment

class MainActivity : FragmentActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentList = listOf(ContactFragment.newInstance(), GalleryFragment.newInstance())
        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList
        binding.mainVp.adapter = adapter

        val tabTitle = listOf<String>("연락처", "갤러리")

        TabLayoutMediator(binding.mainTab, binding.mainVp){ tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }

}