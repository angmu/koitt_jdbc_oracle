package com.javalec.ex.BCommand.MainCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MainCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response);
}
