package View;

import javax.swing.JButton;
import javax.swing.JPanel;

import Model.Item;

public interface Display
{
    public void Frame();
    public void onSubmit(Item item, JButton But);
    public void onItemLink(Item item, JButton but);
}
