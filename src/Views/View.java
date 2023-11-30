package Views;

import Tecnico.FrmTecnicos;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public interface View<Class> {

    public static void showInternal(JDesktopPane desk, JInternalFrame frm) {
        showInternal(desk, frm);
    }

    public static void showInternal(JDesktopPane desk, FrmTecnicos frm) {
        int desktopWidth = desk.getWidth();
        int desktopHeight = desk.getHeight();
        int internalFrameWidth = frm.getWidth();
        int internalFrameHeight = frm.getHeight();
        int x = (desktopWidth - internalFrameWidth) / 2;
        int y = (desktopHeight - internalFrameHeight) / 2;
        frm.setLocation(x, y);
        desk.add(frm);
        frm.setVisible(true);
    }
        void displayMessage(String message);

    public void display(Class obj);
    
    public static void maximize(JFrame frm) {
        frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
