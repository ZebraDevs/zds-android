package com.zebra.zdsDemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.fragment.app.Fragment;

import com.zebra.zdsDemo.R;

import java.util.LinkedList;
import java.util.List;

public class DropdownFragment extends Fragment {

    enum DropdownStyle {
        DEFAULT, DEFAULT_CONDENSED,
        RADIO, RADIO_CONDENSED,
        CHECKBOX, CHECKBOX_CONDENSED,
        COUNTRY, COUNTRY_CONDENSED
    }

    public DropdownFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_dropdown, container, false);

        root.findViewById(R.id.defaultButton).setOnClickListener(v -> showMenu(v, DropdownStyle.DEFAULT));

        root.findViewById(R.id.defaultCondensedButton).setOnClickListener(v -> showMenu(v, DropdownStyle.DEFAULT_CONDENSED));

        root.findViewById(R.id.radioButton).setOnClickListener(v -> showMenu(v, DropdownStyle.RADIO));

        root.findViewById(R.id.radioCondensedButton).setOnClickListener(v -> showMenu(v, DropdownStyle.RADIO_CONDENSED));

        root.findViewById(R.id.checkboxButton).setOnClickListener(v -> showMenu(v, DropdownStyle.CHECKBOX));

        root.findViewById(R.id.checkboxCondensedButton).setOnClickListener(v -> showMenu(v, DropdownStyle.CHECKBOX_CONDENSED));

        root.findViewById(R.id.countryButton).setOnClickListener(v -> showMenu(v, DropdownStyle.COUNTRY));

        root.findViewById(R.id.countryCondensedButton).setOnClickListener(v -> showMenu(v, DropdownStyle.COUNTRY_CONDENSED));

        return root;
    }

    private void showMenu(View view, DropdownStyle style) {
        ListPopupWindow listPopupWindow = new ListPopupWindow(requireContext(), null, R.attr.listPopupWindowStyle);

        // Set button as the list popup's anchor
        listPopupWindow.setAnchorView(view);

        // Set list popup's content
        LinkedList<ListPopupItem> items = new LinkedList<>();
        items.add(new ListPopupItem("Option 1"));
        items.add(new ListPopupItem("Option 2"));
        items.add(new ListPopupItem("Option 3"));
        items.add(new ListPopupItem("Option 4"));

        int itemResId = R.layout.dropdown_item;
        switch (style) {
            case DEFAULT:
                break;
            case DEFAULT_CONDENSED:
                itemResId = R.layout.dropdown_item_condensed;
                break;
            case RADIO:
                itemResId = R.layout.dropdown_item_radio;
                break;
            case RADIO_CONDENSED:
                itemResId = R.layout.dropdown_item_radio_condensed;
                break;
            case CHECKBOX:
                itemResId = R.layout.dropdown_item_checkbox;
                break;
            case CHECKBOX_CONDENSED:
                itemResId = R.layout.dropdown_item_checkbox_condensed;
                break;
            case COUNTRY:
                itemResId = R.layout.dropdown_item_icon;
                items.clear();
                items.add(new ListPopupItem("Option 1", R.drawable.ic_flag_round));
                items.add(new ListPopupItem("Option 2", R.drawable.ic_flag_round));
                items.add(new ListPopupItem("Option 3", R.drawable.ic_flag_round));
                items.add(new ListPopupItem("Option 4", R.drawable.ic_flag_round));
                break;
            case COUNTRY_CONDENSED:
                itemResId = R.layout.dropdown_item_icon_condensed;
                items.clear();
                items.add(new ListPopupItem("Option 1", R.drawable.ic_flag_round));
                items.add(new ListPopupItem("Option 2", R.drawable.ic_flag_round));
                items.add(new ListPopupItem("Option 3", R.drawable.ic_flag_round));
                items.add(new ListPopupItem("Option 4", R.drawable.ic_flag_round));
                break;
        }

        ListPopupWindowAdapter adapter = new ListPopupWindowAdapter(items);
        adapter.layoutResId = itemResId;
        listPopupWindow.setAdapter(adapter);

        // Set list popup's item click listener
        listPopupWindow.setOnItemClickListener((parent, view1, position, id) -> listPopupWindow.dismiss());
        listPopupWindow.show();
    }

    public static class ListPopupItem {
        public String title;
        public int image;
        public ListPopupItem(String title) {
            this.title = title;
        }
        public ListPopupItem(String title, int image) {
            this.title = title;
            this.image = image;
        }
    }

    public class ListPopupWindowAdapter extends BaseAdapter {
        private final List<ListPopupItem> items;
        public int layoutResId;

        public ListPopupWindowAdapter(List<ListPopupItem> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public ListPopupItem getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getItem(position).title);
            if (holder.image != null) {
                holder.image.setImageResource(getItem(position).image);
            }

            return convertView;
        }

        class ViewHolder {
            TextView text;
            AppCompatImageView image;
            ViewHolder(View view) {
                text = view.findViewById(R.id.text);
                image = view.findViewById(R.id.image);
            }
        }
    }
}