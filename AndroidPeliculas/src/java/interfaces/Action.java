/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Abad
 */
public interface Action {
	 public String execute(
	            HttpServletRequest request, 
	            HttpServletResponse response
	   ); 

}
