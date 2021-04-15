package com.hyunjung.toyprojectapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hyunjung.toyprojectapp.R
import com.hyunjung.toyprojectapp.contact.Contact
import com.hyunjung.toyprojectapp.databinding.ItemContactBinding

class ContactAdapter : RecyclerView.Adapter<Holder>() {

    private lateinit var binding: ItemContactBinding
    var contactData = mutableListOf<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_contact, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val contact = contactData.get(position)

        holder.setContact(contact)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = contactData.size

}

class Holder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setContact(contact : Contact) {
        binding.contact = Contact(contact.Name, contact.age, contact.PhoneNum, contact.Country)
    }

}