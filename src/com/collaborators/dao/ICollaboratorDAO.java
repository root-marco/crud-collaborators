package com.collaborators.dao;

import java.util.List;

import com.collaborators.model.Collaborator;

public interface ICollaboratorDAO {

  public void register(Collaborator collaborator);

  public List<Collaborator> findAll();

  public void update(Collaborator collaborator);

  public void remove(int id);

  public Collaborator findId(int id);

}