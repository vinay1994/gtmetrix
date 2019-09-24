package com.epikso.getmatrix.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.epikaso.getmatrix.config.Constants;
import com.epikso.getmatrix.helper.Base;

public class PropertyUtil extends Base {

	public static void loadProperty() throws IOException {
	prop=new Properties();
	input=new FileInputStream(Constants.PROP_FILE);
	prop.load(input);
	
	}
}
