package dsa2017.swing;

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.dsa.app.ProtoMenuBar;

public class SwingMenuBar 
{
	public void bind() 
	{
		for(Field fj: ProtoMenuBar.class.getFields())
		try
		{
			SwingActionMarker tj = fj.getAnnotation(SwingActionMarker.class);
			if(tj == null) continue;
			
			JMenuItem mj = (JMenuItem)fj.get(this);
			
			bind(mj, tj.value(), fj);
		}
		catch(Exception xp) {
			xp.printStackTrace();
		}
	}
	
	public void bind(JMenuItem mj, Class<? extends SwingActionListener> cj, Field fj) throws Exception
	{
		System.out.println("binding " + mj.getText() + " to " + cj.getName());	
		
		SwingActionListener tj = cj.newInstance();
		tj.setActionParams(mj, cj, fj);
		mj.addActionListener(tj);
	}

	
	protected JMenu newJMenu(String name, int key) 
	{
		JMenu res = new JMenu(name);
		res.setMnemonic(key);
		return res;
	}
	
	protected JMenuItem newJMenuItem(String name, int alt, int ctrl) 
	{
		JMenuItem res = new JMenuItem(name);		
		res.setMnemonic(alt);
		res.setAccelerator(KeyStroke.getKeyStroke(ctrl, ActionEvent.CTRL_MASK));		
		return res;
	}

}
