package Views;

import Cita.FrmCitas;
import Revision.FrmRevisiones;
import Tecnico.FrmTecnicos;
import Vehiculo.FrmVehiculos;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public interface View<Class> {

    public static void showInternalTecnicos(JDesktopPane desk, FrmTecnicos frm) {
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

    public static void showInternalVehiculos(JDesktopPane desk, FrmVehiculos frm) {
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

    public static void showInternalCitas(JDesktopPane desk, FrmCitas frm) {
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
    
    public static void showInternalRevisiones(JDesktopPane desk, FrmRevisiones frm) {
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
