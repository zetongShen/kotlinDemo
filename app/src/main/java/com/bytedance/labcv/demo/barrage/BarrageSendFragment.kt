package com.bytedance.labcv.demo.barrage

import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.bytedance.labcv.demo.R
import com.bytedance.labcv.demo.databinding.BarrageSendViewBinding
import com.bytedance.labcv.demo.viewmodels.BarrageSendViewModel

class BarrageSendFragment: DialogFragment() {

    private lateinit var bind : BarrageSendViewBinding
    private var mInputMethodManager: InputMethodManager? = null
    private val barSendViewModel: BarrageSendViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.BarrageInputDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        showDialog()
        mInputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        bind = BarrageSendViewBinding.inflate(inflater, container, false)
        bind.llOutsideView.setOnClickListener {
            dismiss()
        }
        bind.llInputView.setOnClickListener {
            mInputMethodManager?.hideSoftInputFromWindow(bind.etInputMessage.getWindowToken(), 0)
            dismiss()
        }
        bind.btnSend.setOnClickListener {
//            val msg: String = mEditText.getText().toString().trim { it <= ' ' }
            if (!TextUtils.isEmpty(barSendViewModel.message.toString())) {
//                val model: BarrageModel = createBarrageModel(msg)
//                sendBarrage(model)
                //TODO 需要发送弹幕
                barSendViewModel.sendBarrage()
                mInputMethodManager!!.showSoftInput(bind.etInputMessage, InputMethodManager.SHOW_FORCED)
                mInputMethodManager!!.hideSoftInputFromWindow(bind.etInputMessage.getWindowToken(), 0)
                dismiss()
            } else {
                Toast.makeText(requireContext(), "输入不能为空", Toast.LENGTH_LONG).show()
            }
            bind.etInputMessage.setText("")
        }
        bind.etInputMessage.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            when (actionId) {
                KeyEvent.KEYCODE_ENDCALL, KeyEvent.KEYCODE_ENTER -> {
                    if (bind.etInputMessage.getText().length > 0) {
                        mInputMethodManager!!.hideSoftInputFromWindow(bind.etInputMessage.getWindowToken(), 0)
                        dismiss()
                    } else {
                        Toast.makeText(requireContext(), "输入不能为空", Toast.LENGTH_LONG).show()
                    }
                    true
                }
                KeyEvent.KEYCODE_BACK -> {
                    dismiss()
                    false
                }
                else -> false
            }
        })

        bind.etInputMessage.background.setColorFilter(requireContext().resources.getColor(R.color.tuichorus_transparent), PorterDuff.Mode.CLEAR)
        return bind.root
    }

    private fun showDialog(){
        dialog?.setCanceledOnTouchOutside(true)
        val window: Window? = dialog?.window
        window?.decorView?.setPadding(0, 0, 0, 0)
        val layoutParams = window?.attributes
        layoutParams?.width = WindowManager.LayoutParams.MATCH_PARENT
        window?.attributes = layoutParams
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }
}