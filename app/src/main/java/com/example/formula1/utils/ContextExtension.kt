package com.example.formula1.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.formula1.R
import com.example.formula1.databinding.BottomSheetLayoutBinding

fun Context.shortToast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}

fun Context.loadCoverImage(image: Any, view: ImageView) {
    Glide.with(this).load(image)
        .error(R.drawable.img_f1_logo).into(view)
}

fun Dialog.showSearchDialog(title: String, action : (String)-> Unit) {
    val dialogBinding = BottomSheetLayoutBinding.inflate(layoutInflater)
    this.run {
        setContentView(dialogBinding.root)
        window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.attributes?.windowAnimations = R.style.DialogAnimation
        window?.setGravity(Gravity.BOTTOM)
        show()
        dialogBinding.textSearch.setOnClickListener {
            dialogBinding.textDialogTitle.text = title
            val key = dialogBinding.etSearch.text.toString()
            action(key)
            this.dismiss()
        }
    }
}
