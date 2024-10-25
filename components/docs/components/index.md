# zds-android components

## [Setup](../../../README.md)

### Table of Contents:

1. [ZdsButton](#ZdsButton)
2. [ZdsIconButton](#ZdsIconButton)
3. [ZdsFAB and ZdsExtendedFAB](#ZdsFAB)
4. [ZdsTextInput](#ZdsTextInput)
5. [ZdsSwitch](#ZdsSwitch)
6. [ZdsRadioButton](#ZdsRadioButton)
7. [ZdsCheckBox](#ZdsCheckBox)
8. [ZdsLinearProgressIndicator](#ZdsLinearProgressIndicator)
9. [ZdsCircularProgressIndicator](#ZdsCircularProgressIndicator)
10. [ZdsToolbar](#ZdsToolbar)
11. [ZdsTabLayout and ZdsTabItem](#ZdsTabLayout)
12. [ZdsListItem](#ZdsListItem)
13. [ZdsDialog](#ZdsDialog)
14. [Dropdown](#Dropdown)
15. [ZdsSearchView](#ZdsSearchView)
16. [ZdsBanner](#ZdsBanner)
17. [ZdsSystemBanner](#ZdsSystemBanner)
18. [ZdsSelectInput](#ZdsSelectInput)

<a name="ZdsButton"></a>

## ZdsButton

### Class:

**com.zebra.zds.ZdsButton** is a subclass of <br>
**com.google.android.material.button.MaterialButton** <br>

### Styles:

- Zds.Button.Primary
- Zds.Button.Primary.Sharp
- Zds.Button.Variant
- Zds.Button.Variant.Sharp
- Zds.Button.Positive
- Zds.Button.Positive.Sharp
- Zds.Button.Negative
- Zds.Button.Negative.Sharp
- Zds.Button.Outline
- Zds.Button.Outline.Sharp
- Zds.Button.Outline.Subtle
- Zds.Button.Outline.Subtle.Sharp
- Zds.Button.Text
- Zds.Button.Text.Sharp
- Zds.Button.Text.Inverse
- Zds.Button.Text.Inverse.Sharp

### Example:

```xml

<com.zebra.zds.ZdsButton android:id="@+id/zebraButtonVariant"
    style="@style/Zds.Button.Variant" android:layout_width="wrap_content"
    android:layout_height="wrap_content" android:text="Button"
    android:theme="@style/Zds.Button.Variant" app:icon="@drawable/ic_baseline_star_24" />
```

To change the color or style of the button, you need to extend one of the ready themes and change
its properties. Another way is to override attributes in the XML layout file.

<a name="ZdsIconButton"></a>

## ZdsIconButton

### Class:

**com.zebra.zds.ZdsIconButton** is a subclass of <br>
**com.google.android.material.button.MaterialButton** <br>

### Styles:

- Zds.IconButton.Primary
- Zds.IconButton.Primary.Sharp
- Zds.IconButton.Variant
- Zds.IconButton.Variant.Sharp
- Zds.IconButton.Positive
- Zds.IconButton.Positive.Sharp
- Zds.IconButton.Negative
- Zds.IconButton.Negative.Sharp
- Zds.IconButton.Outline
- Zds.IconButton.Outline.Sharp
- Zds.IconButton.Outline.Subtle
- Zds.IconButton.Outline.Subtle.Sharp
- Zds.IconButton.Basic
- Zds.IconButton.Basic.Sharp
- Zds.IconButton.Basic.Inverse
- Zds.IconButton.Basic.Inverse.Sharp
- Zds.IconButton.Basic.Negative
- Zds.IconButton.Basic.Negative.Sharp

### Example:

```xml

<com.zebra.zds.ZdsIconButton android:id="@+id/zebraIconButton"
    style="@style/Zds.IconButton.Primary" android:layout_width="wrap_content"
    android:layout_height="wrap_content" android:theme="@style/Zds.IconButton.Primary"
    app:icon="@drawable/ic_baseline_more_vert_24" />
```

To change the color or style of the button, you need to extend one of the ready themes and change
its properties. Another way is to override attributes in the XML layout file.

<a name="FAB"></a>

## ZdsFAB

## Class:

**com.zebra.zds.ZdsFAB** is a subclass of <br>
**com.google.android.material.floatingactionbutton.FloatingActionButton**
<br><br>
**com.zebra.zds.ZdsExtendedFAB** is a subclass of <br>
**com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton**

## Styles:

- Zds.FAB.Primary
- Zds.FAB.Variant
- Zds.FAB.Negative
- Zds.FAB.Inverse
- Zds.FAB.Extended.Primary
- Zds.FAB.Extended.Variant
- Zds.FAB.Extended.Negative
- Zds.FAB.Extended.Inverse
  <br><br>Shapes:
- Zds.FAB.Shape.Circle
- Zds.FAB.Shape.Rounded
- Zds.FAB.Shape.Sharp

## Example:

```xml

<com.zebra.zds.ZdsExtendedFAB android:id="@+id/zebraFABExtendedInverse"
    style="@style/Zds.FAB.Extended.Inverse" android:layout_width="wrap_content"
    android:layout_height="wrap_content" android:text="Label"
    android:theme="@style/Zds.FAB.Extended.Inverse" app:icon="@drawable/ic_baseline_add_24"
    app:shapeAppearanceOverlay="@style/Zds.FAB.Shape.Circle" />
```

To change the color or style of the button, you need to extend one of the ready themes and change
its properties. Another way is to override attributes in the XML layout file. To change only the
shape change only the **app:shapeAppearanceOverlay** attribute with one of the **
Zds.FAB.Shape.<>** styles.

<a name="ZdsTextInput"></a>

## ZdsTextInput

## Class:

The class **com.zebra.zds.ZdsTextInput** is a custom view which includes <br>
**com.google.android.material.textfield.TextInputEditText** <br>nested inside<br>
**com.google.android.material.textfield.TextInputLayout**<br>
All views have public visibility and can be used in code by accessing them directly.

## Styles:

- Zds.TextInput
- Zds.TextInput.Sharp
- Zds.TextInput.Dense
- Zds.TextInput.Dense.Sharp

## Attributes:

| Name              | Format                    | Info                                 |
| ----------------- | ------------------------- | ------------------------------------ |
| label             | string or reference       | Custom label above the text input.   |
| label_style       | none, mandatory, optional | Style of the label.                  |
| hint              | string or reference       | Custom hint below the text input.    |
| prefixText        | string                    | Static prefix inside the text input. |
| suffixText        | string                    | Static suffix inside the text input. |
| startIconDrawable | reference                 | Drawable at the start of the input.  |
| endIconDrawable   | reference                 | Drawable at the end of the input.    |

## Methods:

| Name                                 | Info                                          |
| ------------------------------------ | --------------------------------------------- |
| setLabel( String label )             | Sets the top label                            |
| setLabel( Int labelResId )           | Sets the top label                            |
| setError( String error )             | Sets the error state and label                |
| setHint( String hint )               | Sets the bottom hint                          |
| connectViewLeft( View view )         | Connects a view on the left                   |
| removeConnectedViewLeft()            | Removes all connected views                   |
| setText(Editable text)               | Sets the text inside the input                |
| getText()                            | Returns the Editable text from the input      |
| setPlaceholder( String placeholder ) | Sets a placeholder hint text inside the input |

## Example:

```xml

<com.zebra.zds.ZdsTextInput android:id="@+id/zebra_text_input"
    android:layout_width="match_parent" android:layout_height="wrap_content"
    android:theme="@style/Zds.TextInput" style="@style/Zds.TextInput" zebra:label="Custom label"
    zebra:label_style="mandatory" zebra:hint="@string/app_name" zebra:prefixText="$"
    zebra:suffixText="@" zebra:endIconDrawable="@drawable/ic_info_sharp"
    zebra:startIconDrawable="@drawable/ic_baseline_star_24" />
```

```java
ZdsTextInput inputDense=root.findViewById(R.id.zebra_text_input_dense);
        inputDense.setHint("Connected left view");

// Create and connect an ImageView to the text input
        ImageView image=new ImageView(getContext());
        image.setImageResource(R.drawable.ic_baseline_star_24);
        image.setBackgroundColor(Color.DKGRAY);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
        image.setLayoutParams(params);
        inputDense.connectViewLeft(image);

// Make it a 4 line input area
        inputDense.getTextInputEditText().setGravity(Gravity.TOP);
        inputDense.getTextInputEditText().setMinLines(4);
```

<a name="ZdsSwitch"></a>

## ZdsSwitch

## Class:

The class **com.zebra.zds.ZdsSwitch** is a subclass of<br>
**com.google.android.material.materialswitch.MaterialSwitch**

## Styles:

- Zds.Switch

## Example:

```xml

<com.zebra.zds.ZdsSwitch android:id="@+id/zebra_switch" android:layout_width="wrap_content"
    android:layout_height="wrap_content" style="@style/Zds.Switch"
    android:theme="@style/Zds.Switch" />
```

<a name="ZdsRadioButton"></a>

## ZdsRadioButton

## Class:

The class **com.zebra.zds.ZdsRadioButton** is a subclass of<br>
**com.google.android.material.radiobutton.MaterialRadioButton**

## Styles:

- Zds.RadioButton

## Example:

```xml

<RadioGroup android:id="@+id/radioGroup" android:orientation="horizontal"
    android:layout_width="wrap_content" android:layout_height="wrap_content">

    <com.zebra.zds.ZdsRadioButton android:id="@+id/option1" android:layout_width="wrap_content"
        android:layout_height="wrap_content" style="@style/Zds.RadioButton"
        android:theme="@style/Zds.RadioButton" />

    <com.zebra.zds.ZdsRadioButton android:id="@+id/option2" android:layout_width="wrap_content"
        android:layout_height="wrap_content" style="@style/Zds.RadioButton"
        android:theme="@style/Zds.RadioButton" />

    <com.zebra.zds.ZdsRadioButton android:id="@+id/option3" android:layout_width="wrap_content"
        android:layout_height="wrap_content" android:enabled="false"
        style="@style/Zds.RadioButton" android:theme="@style/Zds.RadioButton" />

    <com.zebra.zds.ZdsRadioButton android:id="@+id/option4" android:layout_width="wrap_content"
        android:layout_height="wrap_content" android:enabled="false" android:checked="true"
        style="@style/Zds.RadioButton" android:theme="@style/Zds.RadioButton" />
</RadioGroup>
```

<a name="ZdsCheckBox"></a>

## ZdsCheckBox

## Class:

The class **com.zebra.zds.ZdsCheckBox** is a subclass of<br>
**com.google.android.material.checkbox.MaterialCheckBox**

## Styles:

- Zds.CheckBox

## Example:

```xml

<com.zebra.zds.ZdsCheckBox android:id="@+id/option1" android:layout_width="wrap_content"
    android:layout_height="wrap_content" app:checkedState="indeterminate"
    style="@style/Zds.CheckBox" android:theme="@style/Zds.CheckBox" />
```

<a name="ZdsLinearProgressIndicator"></a>

## ZdsLinearProgressIndicator

## Class:

The class **com.zebra.zds.ZdsLinearProgressIndicator** is a composite view which contains<br>
**com.google.android.material.progressindicator.LinearProgressIndicator**

## Styles:

- Zds.LinearProgressIndicator
- Zds.LinearProgressIndicator.Sharp
- Zds.LinearProgressIndicator.Medium
- Zds.LinearProgressIndicator.Medium.Sharp

## Attributes:

| Name           | Format              | Info                                                          |
| -------------- | ------------------- | ------------------------------------------------------------- |
| label          | string or reference | Label shown above the indicator.                              |
| indeterminate  | boolean             | Toggles the indeterminate property of the progress bar.       |
| max            | integer             | Maximum progress.                                             |
| progress       | integer             | Current progress.                                             |
| buffering      | boolean             | Toggles the visibility of three dots right of the indicator." |
| trackThickness | integer             | Size of the progress bar.                                     |

## Methods:

| Name                      | Info               |
| ------------------------- | ------------------ |
| setLabel(String label)    | Sets the label.    |
| setLabel(int labelResId)  | Sets the label.    |
| setProgress(int progress) | Sets the progress. |

## Example:

```xml

<com.zebra.zds.ZdsLinearProgressIndicator android:id="@+id/progressIndicatorLinearMedium"
    android:layout_width="match_parent" android:layout_height="wrap_content"
    zebra:indeterminate="false" zebra:buffering="true" zebra:max="100" zebra:progress="50"
    style="@style/Zds.LinearProgressIndicator.Medium"
    android:theme="@style/Zds.LinearProgressIndicator.Medium" />
```

<a name="ZdsCircularProgressIndicator"></a>

## ZdsCircularProgressIndicator

## Class:

The class **com.zebra.zds.ZdsCircularProgressIndicator** is a composite view which contains<br>
**com.google.android.material.progressindicator.CircularProgressIndicator**

## Styles:

- Zds.CircularProgressIndicator
- Zds.CircularProgressIndicator.Sharp

## Attributes:

| Name          | Format              | Info                                                    |
| ------------- | ------------------- | ------------------------------------------------------- |
| label         | string or reference | Label shown in the center of the indicator.             |
| indeterminate | boolean             | Toggles the indeterminate property of the progress bar. |
| max           | integer             | Maximum progress.                                       |
| progress      | integer             | Current progress.                                       |

## Methods:

| Name                                          | Info                                                |
| --------------------------------------------- | --------------------------------------------------- |
| setLabel(String label)                        | Sets the label.                                     |
| setLabel(int labelResId)                      | Sets the label.                                     |
| setProgress(int progress)                     | Sets the progress.                                  |
| enableActionView( boolean enable)             | Toggles the visibility of the button in the center. |
| setActionListener( OnClickListener listener ) | Sets the listener to the action view.               |

## Example:

```xml

<com.zebra.zds.ZdsCircularProgressIndicator android:id="@+id/progressIndicatorCircular"
    android:layout_width="64dp" android:layout_height="64dp" zebra:indeterminate="false"
    zebra:max="100" zebra:progress="50" style="@style/Zds.CircularProgressIndicator"
    android:theme="@style/Zds.CircularProgressIndicator" />
```

<a name="ZdsToolbar"></a>

## ZdsToolbar

## Class:

The class **com.zebra.zds.ZdsToolbar** is a subclass of<br>
**com.google.android.material.appbar.MaterialToolbar**

## Styles:

- Zds.Toolbar

## Example:

```xml

<com.zebra.zds.ZdsToolbar android:id="@+id/toolbar_avatar" style="@style/Zds.Toolbar"
    android:layout_width="match_parent" android:layout_height="?attr/actionBarSize"
    android:theme="@style/Zds.Toolbar" app:titleMarginTop="16dp" app:titleCentered="true"
    app:navigationIconTint="@android:color/white" app:navigationIcon="@drawable/ic_baseline_menu_24"
    app:logo="@drawable/ic_baseline_emoji_emotions_24" app:menu="@menu/app_menu"
    app:title="@string/app_name" android:layout_marginTop="24dp" />
```

<br>
To make it expandable it should be included in a CoordinatorLayout like this:<br>

```xml

<androidx.coordinatorlayout.widget.CoordinatorLayout android:layout_width="match_parent"
    android:layout_height="match_parent" android:fitsSystemWindows="true">

    <com.google.android.material.appbar.AppBarLayout android:id="@+id/app_bar_layout"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:fitsSystemWindows="true" app:expanded="false">

        <com.google.android.material.appbar.CollapsingToolbarLayout android:fitsSystemWindows="true"
            android:id="@+id/collapsingToolbar" android:layout_width="match_parent"
            android:layout_height="?attr/collapsingToolbarLayoutMediumSize"
            android:theme="@style/Zds.Toolbar" style="@style/Zds.Toolbar"
            app:layout_scrollFlags="scroll|exitUntilCollapsed|snap">

            <com.zebra.zds.ZdsToolbar android:id="@+id/toolbar" style="@style/Zds.Toolbar"
                android:layout_width="match_parent" android:layout_height="?attr/actionBarSize"
                android:theme="@style/Zds.Toolbar" app:layout_collapseMode="pin"
                app:layout_scrollFlags="scroll|enterAlways|snap" app:menu="@menu/app_menu"
                app:title="@string/app_name" />
        </com.google.android.material.appbar.CollapsingToolbarLayout>
    </com.google.android.material.appbar.AppBarLayout>

    <androidx.core.widget.NestedScrollView android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_behavior="@string/appbar_scrolling_view_behavior">

    </androidx.core.widget.NestedScrollView>
</androidx.coordinatorlayout.widget.CoordinatorLayout>
```

<a name="Tabs"></a>

## ZdsTabLayout

## Class:

**com.zebra.zds.ZdsTabLayout** is a subclass of <br>
**com.google.android.material.tabs.TabLayout**
<br><br>
**com.zebra.zds.ZdsTabItem** is a subclass of <br>
**com.google.android.material.tabs.TabItem**

## Styles:

- Zds.TabLayout
- Zds.TabItem

## Example:

```xml

<com.zebra.zds.ZdsTabLayout android:id="@+id/tabLayout" android:layout_width="match_parent"
    android:layout_height="wrap_content" style="@style/Zds.TabLayout"
    android:theme="@style/Zds.TabLayout" app:tabMode="fixed">

    <com.zebra.zds.ZdsTabItem android:id="@+id/tab1" android:layout_width="wrap_content"
        android:layout_height="wrap_content" android:text="Tab1"
        android:icon="@drawable/ic_baseline_star_24" />

    <com.zebra.zds.ZdsTabItem android:id="@+id/tab2" android:layout_width="wrap_content"
        android:layout_height="wrap_content" android:text="Tab2"
        android:icon="@drawable/ic_baseline_star_24" />

    <com.zebra.zds.ZdsTabItem android:id="@+id/tab3" android:layout_width="wrap_content"
        android:layout_height="wrap_content" android:text="Tab3"
        android:icon="@drawable/ic_baseline_star_24" />

</com.zebra.zds.ZdsTabLayout>
```

To make it continuous change the tabMode attribute to **scrollable**

<a name="Lists"></a>

## ZdsListItem

## Class:

- **com.zebra.zds.ZdsListItem** is a helper class to instantiate list view holders.
- **com.zebra.zds.ZdsListItem.ZdsViewHolder** is class for use with a **RecyclerView**.

## Elements:

All elements have generated setters and getters.

- MaterialTextView content
- MaterialTextView descriptor
- MaterialTextView meta
- ShapeableImageView iconLeft
- ShapeableImageView iconRight
- ZdsCheckBox actionView

## Methods:

### ZdsListItem

| Name                             | Info                                                 |
| -------------------------------- | ---------------------------------------------------- |
| getListItem(ViewGroup viewGroup) | Static method that returns a view for ZdsViewHolder. |

### ZdsViewHolder

| Name                     | Info                   |
| ------------------------ | ---------------------- |
| showIconLeft(int resId)  | Shows the left icon.   |
| hideIconLeft(int resId)  | Hides the left icon.   |
| showIconRight(int resId) | Shows the right icon.  |
| hideIconRight(int resId) | Hides the right icon.  |
| setMeta(String text)     | Sets the meta text.    |
| showActionView()         | Shows the action view. |
| hideActionView()         | Hides the action view. |

## Example:

An example **RecyclerView** adapter which uses the **ZdsViewHolder**:

```java
class ZdsListAdapter extends RecyclerView.Adapter<ZdsListItem.ZdsViewHolder> {

    public ZdsListAdapter() {

    }

    @NonNull
    @Override
    public ZdsListItem.ZdsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ZdsListItem.ZdsViewHolder(ZdsListItem.Companion.getListItem(viewGroup));
    }

    @Override
    public void onBindViewHolder(ZdsListItem.ZdsViewHolder viewHolder, final int position) {
        Objects.requireNonNull(viewHolder.getDescriptor()).setText("Descriptor " + position);
        Objects.requireNonNull(viewHolder.getContent()).setText("List Item " + position);

        viewHolder.showIconLeft(R.drawable.ic_baseline_star_24);
        viewHolder.showActionView();
    }

    @Override
    public int getItemCount() {
        return 16;
    }
}
```

To add dividers to the list add an ItemDecoration:

```java
list.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
```

<a name="ZdsDialog"></a>

## ZdsDialog

## Class:

**com.zebra.zds.ZdsDialog** is a subclass of **android.app.Dialog**<br>
To instantiate a dialog use the Builder class **com.zebra.zds.ZdsDialog.Builder**

## Styles:

- Zds.Dialog.NegativeButton

## Methods:

The methods of the Builder class:<br>

| Name                                                     | Info                                        |
| -------------------------------------------------------- | ------------------------------------------- |
| setTitle(String text)                                    | Sets the title text.                        |
| setContent(String text)                                  | Sets the body text.                         |
| setIcon(int iconResId)                                   | Sets the icon resource.                     |
| setPositiveAction(String text, OnClickListener listener) | Sets the positive action text and listener. |
| setNegativeAction(String text, OnClickListener listener) | Sets the negative action text and listener. |
| setNeutralAction(String text, OnClickListener listener)  | Sets the neutral action text and listener.  |
| setTitleGravity(int gravity)                             | Sets the gravity for title and icon.        |
| setIsSharp(boolean isSharp)                              | Sets if the dialog has sharp style.         |
| build()                                                  | Builds and returns a ZdsDialog.             |

To use the negative action a positive one should be set. To use a neutral action a positive and
negative ones should be set.<br>

## Example:

```java
ZdsDialog.Builder builder=new ZdsDialog.Builder(getContext());
        builder.setTitle("Dialog Title")
        .setContent("Lorem ipsum dolor sit amet")
        .setPositiveAction("Confirm",listener)
        .setNegativeAction("Cancel",listener)
        .setNeutralAction("Learn More",listener)
        .setIcon(R.drawable.ic_baseline_warning_24)
        .setTitleGravity(Gravity.CENTER)
        .setIsSharp(false)
        .build()
        .show()
```

<a name="Dropdown"></a>

## Dropdown

Dropdowns are implemented by creating a **ListPopupWindow** and providing a custom adapter with the
required layout items.

## Layout:

- R.layout.dropdown_item
- R.layout.dropdown_item_condensed
- R.layout.dropdown_item_checkbox
- R.layout.dropdown_item_checkbox_condensed
- R.layout.dropdown_item_radio
- R.layout.dropdown_item_radio_condensed
- R.layout.dropdown_item_icon
- R.layout.dropdown_item_icon_condensed

## Styles:

- Zds.Dropdown

## Example:

An example custom adapter:<br>

```java
public class ListPopupItem {
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
  public ListPopupItem getItem(int position) {
    return items.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
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

  static class ViewHolder {
    TextView text;
    AppCompatImageView image;

    ViewHolder(View view) {
      text = view.findViewById(R.id.text);
      image = view.findViewById(R.id.image);
    }
  }
}
```

Implementing the whole dropdown:

```java
// Init popup list
ListPopupWindow listPopupWindow=new ListPopupWindow(requireContext(),null,R.attr.listPopupWindowStyle);

// Set button as the list popup's anchor
        listPopupWindow.setAnchorView(view);

// Set list popup's content
        LinkedList<ListPopupItem> items=new LinkedList<ListPopupItem>();
        items.add(new ListPopupItem("Option 1",R.drawable.ic_baseline_flag_24));
        items.add(new ListPopupItem("Option 2",R.drawable.ic_baseline_flag_24));
        items.add(new ListPopupItem("Option 3",R.drawable.ic_baseline_flag_24));
        items.add(new ListPopupItem("Option 4",R.drawable.ic_baseline_flag_24));

// Init adapter
        int itemResId=R.layout.dropdown_item_icon;
        ListPopupWindowAdapter adapter=new ListPopupWindowAdapter(items);
        adapter.layoutResId=itemResId;
        listPopupWindow.setAdapter(adapter);

// Set list popup's item click listener
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener(){
@Override
public void onItemClick(AdapterView<?> parent,View view,int position,long id){
        listPopupWindow.dismiss();
        }
        });
        listPopupWindow.show();
```

<a name="ZdsSearchView"></a>

## ZdsSearchView

## Class:

**com.zebra.zds.ZdsSearchView** is a subclass of<br>
**androidx.appcompat.widget.SearchView**

## Styles:

- Zds.SearchView - to use with Toolbars
- Zds.SearchView.Layout - inside layouts
- Zds.SearchView.Layout.Inverse - inside layouts

## Example:

```xml

<com.zebra.zds.ZdsSearchView android:id="@+id/zebra_search" android:layout_width="match_parent"
    android:layout_height="wrap_content" style="@style/Zds.SearchView.Layout"
    android:theme="@style/Zds.SearchView.Layout" />
```

<a name="ZdsBanner"></a>

## ZdsBanner

## Class:

**com.zebra.zds.ZdsBanner** is a composite view

## Attributes:

| Name         | Format                                  | Info                  |
| ------------ | --------------------------------------- | --------------------- |
| message      | string or reference                     | Banner message.       |
| title        | string or reference                     | Banner title.         |
| banner_style | none, info, positive, warning, negative | Style for the banner. |
| isSharp      | boolean                                 | Sharp style enabled.  |

## Methods:

| Name                                                | Info                    |
| --------------------------------------------------- | ----------------------- |
| setMessageString( String message )                  | Sets the message        |
| setTitleString( String title )                      | Sets the title          |
| setSharp( boolean isSharp )                         | Sets the sharp style    |
| setStyle( ZdsBanner.Style style )                   | Sets the banner style   |
| setCloseAction( OnClickListener action )            | Sets the close action.  |
| setActionOne( String text, OnClickListener action ) | Sets the first action.  |
| setActionTwo( String text, OnClickListener action ) | Sets the second action. |

## Example:

To use the banner inside a layout place it inside a **MotionLayout**.

```xml

<androidx.constraintlayout.motion.widget.MotionLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools" android:id="@+id/motionLayout"
    android:layout_width="match_parent" android:layout_height="wrap_content"
    app:layoutDescription="@xml/banner_scene" tools:applyMotionScene="false">

    <com.zebra.zds.ZdsBanner android:id="@+id/banner" android:layout_width="match_parent"
        android:layout_height="wrap_content" android:visibility="gone"
        app:layout_constraintEnd_toEndOf="parent" app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.motion.widget.MotionLayout>
```

Define the transitions:

```xml
<?xml version="1.0" encoding="utf-8"?>
<MotionScene xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:motion="http://schemas.android.com/apk/res-auto">
    <Transition motion:constraintSetEnd="@+id/end" motion:constraintSetStart="@+id/start"
        motion:duration="300" />
    <ConstraintSet android:id="@+id/start">
        <Constraint android:id="@+id/banner" android:layout_width="match_parent"
            android:layout_height="wrap_content" motion:layout_constraintBottom_toTopOf="parent" />
    </ConstraintSet>
    <ConstraintSet android:id="@+id/end">
        <Constraint android:id="@+id/banner" android:layout_width="match_parent"
            android:layout_height="wrap_content" motion:layout_constraintTop_toTopOf="parent" />
    </ConstraintSet>
</MotionScene>
```

Define the methods for show/hide:

```java
private void showBanner(){
        banner.setVisibility(View.VISIBLE);
        motionLayout.transitionToEnd();
        }

private void hideBanner(){
        motionLayout.transitionToStart();
        }
```

<a name="ZdsSystemBanner"></a>

## ZdsSystemBanner

## Class:

**com.zebra.zds.ZdsSystemBanner** is a composite view

## Attributes:

| Name           | Format                            | Info                  |
| -------------- | --------------------------------- | --------------------- |
| title          | string or reference               | Banner title.         |
| banner_style   | none, positive, warning, negative | Style for the banner. |
| title_centered | boolean                           | Centers the title.    |

## Methods:

| Name                              | Info                  |
| --------------------------------- | --------------------- |
| setTitleString( String title )    | Sets the title        |
| centerTitle( boolean isCentered ) | Centers the title.    |
| setStyle( ZdsBanner.Style style ) | Sets the banner style |

## Example:

To use the banner inside a layout place it inside a **MotionLayout**.

```xml

<androidx.constraintlayout.motion.widget.MotionLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools" android:id="@+id/motionLayout"
    android:layout_width="match_parent" android:layout_height="wrap_content"
    app:layoutDescription="@xml/banner_scene" tools:applyMotionScene="false">

    <com.zebra.zds.ZdsSystemBanner android:id="@+id/system_banner"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:visibility="gone" app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.motion.widget.MotionLayout>
```

Define the transitions:

```xml
<?xml version="1.0" encoding="utf-8"?>
<MotionScene xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:motion="http://schemas.android.com/apk/res-auto">
    <Transition motion:constraintSetEnd="@+id/end" motion:constraintSetStart="@+id/start"
        motion:duration="300" />
    <ConstraintSet android:id="@+id/start">
        <Constraint android:id="@+id/system_banner" android:layout_width="match_parent"
            android:layout_height="wrap_content" motion:layout_constraintBottom_toTopOf="parent" />
    </ConstraintSet>
    <ConstraintSet android:id="@+id/end">
        <Constraint android:id="@+id/system_banner" android:layout_width="match_parent"
            android:layout_height="wrap_content" motion:layout_constraintTop_toTopOf="parent" />
    </ConstraintSet>
</MotionScene>
```

Define the methods for show/hide:

```java
private void showBanner(){
    ZdsSystemBanner.Style style = banner.getStyle();
    int statusBarColor = R.color.zebra_black_toolbar;
    switch(style){
        case DEFAULT:
            statusBarColor=R.color.zebra_blue_enabled;
            break;
        case POSITIVE:
            statusBarColor=R.color.zebra_green_system_banner;
            break;
        case WARNING:
            statusBarColor=R.color.zebra_yellow_system_banner;
            break;
        case NEGATIVE:
            statusBarColor=R.color.zebra_red_enabled;
            break;
    }
    getWindow().setStatusBarColor(ContextCompat.getColor(this, statusBarColor));
    banner.setVisibility(View.VISIBLE);
    motionLayout.transitionToEnd();
}

private void hideBanner(){
    motionLayout.transitionToStart();
}
```

<a name="ZdsSelectInput"></a>

## ZdsSelectInput

## Class:

The class **com.zebra.zds.ZdsSelectInput** is a custom view which includes <br>
**AutoCompleteTextView** <br>nested inside<br>
**com.google.android.material.textfield.TextInputLayout**<br>
All views have public visibility and can be used in code by accessing them directly.

## Styles:

- Zds.SelectInput
- Zds.SelectInput.Sharp
- Zds.SelectInput.Dense
- Zds.SelectInput.Dense.Sharp

## Attributes:

| Name              | Format              | Info                                |
| ----------------- | ------------------- | ----------------------------------- |
| hint              | string or reference | Custom hint below the text input.   |
| startIconDrawable | reference           | Drawable at the start of the input. |

## Methods:

| Name                                 | Info                                          |
| ------------------------------------ | --------------------------------------------- |
| setError( String error )             | Sets the error state and label                |
| setHint( String hint )               | Sets the bottom hint                          |
| setPlaceholder( String placeholder ) | Sets a placeholder hint text inside the input |

## Example:

```xml
 <com.zebra.zds.ZdsSelectInput
        android:id="@+id/zebra_select_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        style="@style/Zds.SelectInput"
        android:theme="@style/Zds.SelectInput"/>
```

```java
ZdsSelectInput selectInput = getView().findViewById(R.id.zebra_select_input);
selectInput.setPlaceholder("Placeholder");

LinkedList<String> items = new LinkedList<String>();
items.add("Item 1");
items.add("Item 2");
items.add("Item 3");
items.add("Item 4");

ArrayAdapter<String> adapter = new ArrayAdapter<String>(requireContext(), R.layout.select_input_item, items);
selectInput.getTextInputEditText().setAdapter(adapter);
```
