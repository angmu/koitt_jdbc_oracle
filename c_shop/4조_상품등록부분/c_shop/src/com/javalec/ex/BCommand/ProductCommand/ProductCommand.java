package com.javalec.ex.BCommand.ProductCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProductCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response);
	
}
