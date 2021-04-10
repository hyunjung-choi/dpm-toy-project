package com.hyunjung.toyprojectapp.contact

import android.app.AlertDialog
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.hyunjung.toyprojectapp.R
import com.hyunjung.toyprojectapp.adapter.ContactAdapter
import com.hyunjung.toyprojectapp.databinding.FragmentContactBinding
import org.json.JSONObject
import java.io.FileNotFoundException


class ContactFragment : Fragment() {

    private lateinit var binding : FragmentContactBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
        binding = FragmentContactBinding.inflate(inflater, container, false)

        val contactData : MutableList<Contact> = loadContactData()
        val contactAdapter = ContactAdapter()
        contactAdapter.contactData = contactData
        binding.contactRv.adapter = contactAdapter
        binding.contactRv.layoutManager = LinearLayoutManager(this.context)

        // 구분선
        val dividerItemDecoration = DividerItemDecoration(binding.contactRv.context, LinearLayoutManager(this.context).orientation)
        binding.contactRv.addItemDecoration(dividerItemDecoration)

        // FAB 클릭 시, 다이얼로그 생성
        binding.contactFabAdd.setOnClickListener {
            val mDialogView = LayoutInflater.from(this.context).inflate(R.layout.dialog_add, null)
            val mBuilder = AlertDialog.Builder(this.context)
                    .setView(mDialogView)

            val mAlterDialog = mBuilder.show()

            val btnOk = mDialogView.findViewById<Button>(R.id.dialog_btn_ok)
            val btnCancel = mDialogView.findViewById<Button>(R.id.dialog_btn_cancel)

            val etName = mDialogView.findViewById<EditText>(R.id.dialog_et_name)
            val etAge = mDialogView.findViewById<EditText>(R.id.dialog_et_age)
            val etCountry = mDialogView.findViewById<EditText>(R.id.dialog_et_country)
            val etPhone = mDialogView.findViewById<EditText>(R.id.dialog_et_phone)

            // 연락처 자동 하이픈 입력
            etPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher())

            btnOk.setOnClickListener {
                val name = etName.text.toString()
                val age = etAge.text.toString()
                val phone = etPhone.text.toString()
                val country = etCountry.text.toString()

                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(age) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(country)){
                    Toast.makeText(this.context, "값을 입력해주세요.", Toast.LENGTH_LONG).show()
                }
                else{
                    contactData.add(0, Contact(name, age.toInt(), phone, country))
                    contactAdapter.notifyDataSetChanged()

                    mAlterDialog.dismiss()
                    Toast.makeText(this.context, "연락처가 등록되었습니다.", Toast.LENGTH_LONG).show()
                }
            }

            btnCancel.setOnClickListener {
                mAlterDialog.dismiss()
            }
        }

        return binding.root
    }

    private fun loadContactData() : MutableList<Contact>{
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

