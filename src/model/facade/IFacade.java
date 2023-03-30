package model.facade;

public interface IFacade {
    boolean loadContacts();
    boolean addContact(String row);
    void save();
}
