package client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import common.IPowerPlant;
import implementation.PowerPlant;
/**
 * Write a description of class PowerPlantTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PowerPlantTable 
{
    // instance variables - replace the example below with your own
    private ArrayList<IPowerPlant> iPlant;
    private String name;
    private double TotalPower;
    /**
     * Constructor for objects of class PowerPlantTable
     */
    public PowerPlantTable(String name)
    {
        // initialise instance variables
        this.name = name;
        iPlant = new ArrayList<IPowerPlant>();
        TotalPower=0;
        //initlist();
    }
    
    public void addPowerStation(IPowerPlant powerstation)
    {
        iPlant.add(powerstation);
        TotalPower=TotalPower+powerstation.getCapacity();
    
    }
    
    public double getPower()
    {
        return TotalPower;
    }
    
    public void printTable()
    {
        System.out.println(IPowerPlant.getHeader());
         for(IPowerPlant powerStation : iPlant) {
            System.out.println(powerStation.printFormat());
        }
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        System.out.println("The total capacity of all NPP: " + getPower());
    
    }
    // private void initlist()
    // {
        // PowerPlant powerPla1 = new PowerPlant("Rooppur", "Bangladesh", 2160, 2017, 2023);
        
        // PowerPlant powerPla2 = new PowerPlant("Akkuyu", "Turkey", 4456, 2015, 2023);
  
         // PowerPlant powerPla3 = new PowerPlant("El Dabaa", "Egypt", 1194, 2022, 2026);
   
         // PowerPlant powerPla4 = new PowerPlant("San'ao", "China", 2234, 2020, 2026);
    
         // PowerPlant powerPla5 = new PowerPlant("Xudabao", "China", 2400, 2021, 2028);
    
         // PowerPlant powerPla6 = new PowerPlant("Zhangzhou", "China", 2252, 2019, 2024);
    
         // this.addPowerStation(powerPla1);
         // this.addPowerStation(powerPla2);
         // this.addPowerStation(powerPla3);
         // this.addPowerStation(powerPla4);
         // this.addPowerStation(powerPla5);
         // this.addPowerStation(powerPla6);
        
    
         
        
    
    // }
   
    public void listPowerPlants(String Country)
    { 
        for(IPowerPlant powerstation: iPlant){
            if(powerstation.getCountry().equals(Country)){
                System.out.println(powerstation.printFormat());
            }
        }
    
    }
    
    public HashSet<IPowerPlant>findPowerPlants(String Country){
        HashSet<IPowerPlant> pPlant = new HashSet<>();
        for(IPowerPlant powerstation: iPlant){
            if(powerstation.getCountry().equals(Country)){
                pPlant.add(powerstation);
            }
        }
        return pPlant;
    
    }
    
    public void listByCountry()
    {
        HashSet<String> countryname = new HashSet<>();
        for(IPowerPlant powerstation: iPlant)
        {
            String Country = powerstation.getCountry();
            countryname.add(Country);
        
        }    
        for(String name : countryname)
        {
            System.out.println("Countryname:" + name);
            listPowerPlants(name);
        
        }
    }
    
    
    public HashMap<String, Double> powerByCountry()
    {
        HashMap<String, Double> pbCountry = new HashMap<>();
        
        
        for(IPowerPlant powerstation: iPlant)
        {
            String Country = powerstation.getCountry();
            if(    pbCountry.containsKey(Country)){
                pbCountry.put(Country,pbCountry.get(Country)+powerstation.getCapacity());
            }
            else
            {
                pbCountry.put(Country,powerstation.getCapacity());
                
            
            }
            
        }
        // for(Map.Entry name : pbCountry.entrySet())
        // {
            // System.out.println("Countryname:" + name);
            
        
        // }
        return pbCountry;
        
    
    }
    public void printCapacity(HashMap<String, Double> pCapacity) 
    {
        HashSet<String> countryname = new HashSet<>();
         for(Map.Entry name : pCapacity.entrySet())
        {
            System.out.println("Countryname:" + name);
        }
        
        for(String name : countryname)
        {
            System.out.println("Countryname:" + name);
            listPowerPlants(name);
        }
    
    }
    
    public HashMap<String, HashSet<IPowerPlant>> mapByCountry()
    {
        HashMap<String, HashSet<IPowerPlant>> mapByCountry = new HashMap<String, HashSet<IPowerPlant>>();
        for(IPowerPlant powerstation: iPlant)
        {
            String Map = powerstation.getCountry();
            HashSet<IPowerPlant> CountryMap = mapByCountry.getOrDefault(Map, new HashSet<IPowerPlant>());
            CountryMap.add(powerstation);
            mapByCountry.put(Map, CountryMap);
        }  
        return mapByCountry;
    }
    
    
    public void printMap(HashMap<String, HashSet<IPowerPlant>> Mapping ) 
    {
        for(Map.Entry<String, HashSet<IPowerPlant>> pMapping : Mapping.entrySet())
        {
        System.out.println(pMapping.getKey());
                
        for(IPowerPlant powerstation: pMapping.getValue())
        {
            System.out.println(powerstation.printFormat());
        
        }
        }
    }
}
