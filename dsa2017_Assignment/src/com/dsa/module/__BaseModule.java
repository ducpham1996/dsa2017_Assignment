package com.dsa.module;

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;

import javax.swing.JMenuItem;

import com.dsa.app.ProtoAppMain;
import com.dsa.app.ProtoMainFrame;

import dsa2017.swing.SwingActionListener;

public class __BaseModule implements SwingActionListener {

	public static ProtoMainFrame useFrame()
	{
		return ProtoAppMain.useFrame();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		useFrame().inspectEvent(arg0);		
	}

	@Override
	public void setActionParams(JMenuItem mj, Class<? extends SwingActionListener> cj, Field fj) 
	{
		System.out.println(  mj.getText()  + " >> " + fj.getName() + " >> " + cj.getName());
		
	}

}
