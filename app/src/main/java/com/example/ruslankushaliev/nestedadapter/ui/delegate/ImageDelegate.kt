package com.example.ruslankushaliev.nestedadapter.ui.delegate

import com.example.ruslankushaliev.nestedadapter.R
import com.example.ruslankushaliev.nestedadapter.ui.entity.Image
import com.example.ruslankushaliev.nestedadapter.ui.template.delegateadapter.BaseDelegateAdapter

class ImageDelegate : BaseDelegateAdapter<Image>() {

    override val itemLayoutId: Int
        get() = R.layout.delegate_image

    override fun BaseViewHolder<Image>.onBind(model: Image) {

    }

    override fun isForItem(item: Any): Boolean = item is Image
}