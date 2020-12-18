package com.nytsample.presentation.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.nytsample.R
import com.nytsample.data.remote.dto.MostPopularResultDto

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun loadImage(imageView: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Glide.with(imageView).load(url).into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("app:imageData")
    fun loadImageData(imageView: ImageView, media: List<MostPopularResultDto.MediaData>?) {
        media?.let {
            if (it.isNotEmpty() && it.get(0).mediaMetadata.isNotEmpty() && !it.get(0).mediaMetadata.get(
                    0
                ).url.isEmpty()
            ) {
                Glide.with(imageView).load(it.get(0).mediaMetadata.get(0).url).into(imageView)
            }
        }

    }

    @JvmStatic
    @BindingAdapter("app:imageCaption")
    fun loadImageCaption(text: TextView, media: List<MostPopularResultDto.MediaData>?) {
        media?.let {
            if (it.isNotEmpty()) {
                text.text = it.get(0).caption
            }
        }

    }

    @JvmStatic
    @BindingAdapter("app:mediumImageData")
    fun loadMediumImageData(imageView: ImageView, media: List<MostPopularResultDto.MediaData>?) {
        media?.let {
            if (it.isNotEmpty() && it.get(0).mediaMetadata.size > 2 && !it.get(0).mediaMetadata.get(
                    2
                ).url.isEmpty()
            ) {
                Glide.with(imageView).load(it.get(0).mediaMetadata.get(2).url).into(imageView)
            } else if (it.isNotEmpty() && it.get(0).mediaMetadata.isNotEmpty() && !it.get(0).mediaMetadata.get(
                    0
                ).url.isEmpty()
            ) {
                Glide.with(imageView).load(it.get(0).mediaMetadata.get(0).url).into(imageView)

            } else {
                Glide.with(imageView).load(R.mipmap.ic_launcher).into(imageView)
            }
        }

    }
}