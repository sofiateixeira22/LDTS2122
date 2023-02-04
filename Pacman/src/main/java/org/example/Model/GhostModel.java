package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class GhostModel  {
   private List<Ghost> ghosts;
   public GhostModel()
   {
       ghosts = new ArrayList<>();
   }
   public List<Ghost> getGhosts()
   {return ghosts; }

   public void addGhost(PositionModel position )
   {ghosts.add(new Ghost(position));}

}

