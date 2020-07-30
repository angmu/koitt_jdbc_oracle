package com.javalec.ex.BCommand.BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response);
}
