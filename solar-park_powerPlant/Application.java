import client.*;
import common.IPowerPlant;
import implementation.SolarPark;
import implementation.PowerPlant;
import implementation.WindFarm;
/**
 * Write a description of class Application here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Application
{
    
    public static void main()
     {
        PowerPlantTable powerPlantTable1 = new PowerPlantTable("table1");
        powerPlantTable1.addPowerStation(new WindFarm("Hornsea Wind Farm", "United Kingdom", 1218,174,2019));
        powerPlantTable1.addPowerStation(new WindFarm("Walney Wind Farm", "United Kingdom",1026,102,2018));
        powerPlantTable1.addPowerStation(new WindFarm("London Array","Denmark",605,72,2021));
        powerPlantTable1.addPowerStation(new WindFarm("Jiangsu Quidong", "China", 802, 134, 2021));
        powerPlantTable1.addPowerStation(new WindFarm("Kriegers Flak","Netherlands",600,150,2017));
        powerPlantTable1.addPowerStation(new WindFarm("Borssele 3&4 ","Netherlands",714,102,2020));
        powerPlantTable1.addPowerStation(new PowerPlant("Akkuyu","Turkey", 4456, 2015,2023));
        powerPlantTable1.addPowerStation(new PowerPlant("El Dabaa","Egypt", 1194, 2022,2026));
        powerPlantTable1.addPowerStation(new PowerPlant("Rooppur", "Bangladesh", 2160, 2017, 2023));
        powerPlantTable1.addPowerStation(new PowerPlant("San’ao","China",2234,2020,2026));
        powerPlantTable1.addPowerStation(new PowerPlant("Xudabao","China",24,2021,2028));
        powerPlantTable1.addPowerStation(new PowerPlant("Zhangzhou","China",2252,2019,2024));
        powerPlantTable1.addPowerStation(new SolarPark("Bhadla Solar Park","India",2700,160,2018));
        powerPlantTable1.addPowerStation(new SolarPark("Jinchuan Solar Park ","China",1030,90,2019));
        powerPlantTable1.addPowerStation(new SolarPark("Pavagada Solar Park","India",2050,53,2019));
        powerPlantTable1.addPowerStation(new SolarPark("Benban Solar Park","Egypt",1650,37,2019));
        powerPlantTable1.addPowerStation(new SolarPark("Cestas Solar Park","France",300,3,2015));
        powerPlantTable1.addPowerStation(new SolarPark("Charanka Solar Park","India",790,20,2012));
        
    
        powerPlantTable1.printTable();
}
}