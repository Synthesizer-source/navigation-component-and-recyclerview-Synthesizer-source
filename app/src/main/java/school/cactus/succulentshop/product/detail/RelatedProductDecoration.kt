package school.cactus.succulentshop.product.detail


import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import school.cactus.succulentshop.R

class RelatedProductDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val layoutParams = (view.layoutParams as RecyclerView.LayoutParams)
        val spacing = view.context.resources.getDimensionPixelSize(R.dimen.related_product_horizontal_spacing)
        val position = parent.getChildAdapterPosition(view)
        if (position <  parent.adapter!!.itemCount - 1) outRect.right = spacing

        layoutParams.width = parent.measuredWidth / 2
        layoutParams.height = RecyclerView.LayoutParams.MATCH_PARENT
        view.layoutParams = layoutParams
    }
}