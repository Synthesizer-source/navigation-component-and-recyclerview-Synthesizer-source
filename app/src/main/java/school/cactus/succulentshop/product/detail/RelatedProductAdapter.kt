package school.cactus.succulentshop.product.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.ItemProductBinding
import school.cactus.succulentshop.product.detail.RelatedProductAdapter.RelatedHolder
import school.cactus.succulentshop.product.list.Product

class RelatedProductAdapter : ListAdapter<Product, RelatedHolder>(DIFF_CALLBACK) {

    var itemClickListener: (Product) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RelatedHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: RelatedHolder, position: Int) = holder.bind(getItem(position))

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
        }
    }

    class RelatedHolder(
        private val binding: ItemProductBinding,
        private val itemClickListener: (Product) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {

            binding.apply {
                titleText.text = product.title
                priceText.text = product.price

                root.setOnClickListener {
                    itemClickListener(product)
                }

                Glide.with(root.context)
                    .load(product.imageUrl)
                    .centerCrop()
                    .override(root.context.resources.getDimensionPixelSize(R.dimen.related_product_image_size))
                    .into(imageView)
            }
        }
    }
}