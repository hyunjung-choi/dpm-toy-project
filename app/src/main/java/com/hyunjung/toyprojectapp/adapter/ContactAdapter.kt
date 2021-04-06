package com.hyunjung.toyprojectapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hyunjung.toyprojectapp.contact.Contact
import com.hyunjung.toyprojectapp.databinding.ItemContactBinding

class ContactAdapter : RecyclerView.Adapter<Holder>() {

    var contactData = mutableListOf<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val contact = contactData.get(position)

        holder.setContact(contact)
    }

    override fun getItemCount(): Int = contactData.size

}

class Holder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setContact(contact : Contact) {
        binding.contactItemTvName.text = "${contact.Name}"
        binding.contactItemTvAge.text = "${contact.age}살"
        binding.contactItemTvPhone.text = "${contact.PhoneNum}"
        binding.contactItemTvCountry.text = "${contact.Country}"
    }

}