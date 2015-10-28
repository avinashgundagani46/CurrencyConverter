package converter.com.currencyconverter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private final Context mContext;
	double sourceAmount = 1;
	int selectedItemPosition = 0;

	String countryname[] = {"Euros", "Pounds", "US Dollars", "Japanese Yen", "Austrailian Dollars", "Canadian Dollars"};

	double euroConversion[] = {1, 0.7289, 1.12974, 136.156, 1.57155, 1.49167};
	double poundConversion[] = {1.371930306, 1, 1.549924544, 186.796542736, 2.156057072, 2.046467279};
	double usDollarConversion[] = {0.885159417,0.645192699,1,120.51976561,1.391072282,1.320365748};
	double japaneseConversion[] = {0.007344517, 0.005353418,0.008297394,1, 0.011542275, 0.010955595 };
	double ausConversion[] = {0.636314467, 0.463809615, 0.718869906, 86.638032516,1, 0.9491712 };
	double canadianConversion[] = {0.670389563, 0.488646953, 0.757365905, 91.277561391, 1.053550718, 1};

	public MyAdapter(Context context){
		mContext = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ViewGroup viewGroup = null;
		convertView = mInflater.inflate(R.layout.item_country, viewGroup);

		TextView text = (TextView) convertView.findViewById(R.id.textView_currency);

		switch (selectedItemPosition){
			case 0:
				double euroAmount = sourceAmount  * euroConversion[position];
				text.setText(euroAmount+" "+countryname[position]);
				break;
			case 1:
				double poundsAmount = sourceAmount  * poundConversion[position];
				text.setText(poundsAmount+" "+countryname[position]);
				break;
			case 2:
				double usDollarsAmount = sourceAmount  * usDollarConversion[position];
				text.setText(usDollarsAmount+" "+countryname[position]);
				break;
			case 3:
				double japanAmount = sourceAmount  * japaneseConversion[position];
				text.setText(japanAmount+" "+countryname[position]);
				break;
			case 4:
				double ausAmount = sourceAmount  * ausConversion[position];
				text.setText(ausAmount+" "+countryname[position]);
				break;
			case 5:
				double canadaAmount = sourceAmount  * canadianConversion[position];
				text.setText(canadaAmount+" "+countryname[position]);
				break;
		}

		return convertView;
	}

	public void setSelectedItem(int position) {
		selectedItemPosition = position;
	}

	public void setSourceAmount(String s) {
		sourceAmount = Double.parseDouble(s);
	}

	@Override
	public int getCount() {
		return 6;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}
}
