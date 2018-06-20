package com.cold.swipedelmenu.refresh;

import android.support.annotation.LayoutRes;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cold.swipedelmenu.R;
import com.cold.swipedelmenu.bean.SwipeBean;
import com.cold.swipedelmenu.view.SwipeMenuLayout;

import java.util.List;

/**
 * Created by baoyz on 2014/6/29.
 */
public class RefreshAdapter extends BaseQuickAdapter<SwipeBean, BaseViewHolder> {

    private ISwipeMenuListener mOnSwipeListener;

    public void setmOnSwipeListener(ISwipeMenuListener mOnSwipeListener) {
        this.mOnSwipeListener = mOnSwipeListener;
    }

    /***********************************************************************
     * 构造函数
     **********************************************************************/
    public RefreshAdapter(@LayoutRes int layoutResId, List<SwipeBean> list) {
        super(layoutResId, list);
    }

    @Override
    protected void convert(final BaseViewHolder baseViewHolder, SwipeBean wsChater) {

        ((SwipeMenuLayout)baseViewHolder.getView(R.id.smlt_item)).setIos(true).setLeftSwipe(true);
        ((SwipeMenuLayout)baseViewHolder.getView(R.id.smlt_item)).setmSwipeListener(new SwipeMenuLayout.ISwipeListener() {
            @Override
            public void onClose() {
                baseViewHolder.getView(R.id.btnDelete).setVisibility(View.VISIBLE);
                baseViewHolder.getView(R.id.btn_sure_delete).setVisibility(View.GONE);
            }
        });
        //验证长按
        baseViewHolder.getView(R.id.llyt_content).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "long click", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        baseViewHolder.getView(R.id.btnDelete).setVisibility(View.VISIBLE);
        baseViewHolder.getView(R.id.btn_sure_delete).setVisibility(View.GONE);
        baseViewHolder.getView(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnSwipeListener) {
//                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
//                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((CstSwipeDelMenu) holder.itemView).quickClose();
//                    //((CstSwipeDelMenu) holder.itemView).quickClose();
//                    mOnSwipeListener.onDel(baseViewHolder.getAdapterPosition());
                    baseViewHolder.getView(R.id.btnDelete).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.btn_sure_delete).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.smlt_item).requestLayout();
                    ((SwipeMenuLayout)baseViewHolder.getView(R.id.smlt_item)).post(new Runnable() {
                        @Override
                        public void run() {
                            ((SwipeMenuLayout)baseViewHolder.getView(R.id.smlt_item)).smoothExpand();
                        }
                    });

                }
            }
        });

        //注意事项，设置item点击，不能对整个holder.itemView设置咯，只能对第一个子View，即原来的content设置，这算是局限性吧。
        baseViewHolder.getView(R.id.llyt_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "onClick() called with: v = [" + v + "]");
                if(mOnSwipeListener != null) {
                    mOnSwipeListener.onClick(RefreshAdapter.this, v, baseViewHolder.getAdapterPosition());
                }
            }
        });
        //置顶：
        baseViewHolder.getView(R.id.btn_sure_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnSwipeListener){
                    mOnSwipeListener.onDel(baseViewHolder.getAdapterPosition());
                }

            }
        });
        baseViewHolder.setText(R.id.tv_name, wsChater.name);
    }

        /**
     * 和Activity通信的接口
     */
    public interface ISwipeMenuListener {
        void onDel(int pos);
        void onClick(BaseQuickAdapter adapter, View v, int position);
        void onTop(int pos);
    }
}
