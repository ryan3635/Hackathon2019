package com.power.hackathon2019.controller;

import com.google.android.gms.maps.model.LatLng;
import com.power.hackathon2019.model.Marker;
import com.power.hackathon2019.model.Street;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;

public class StreetBuilder
{
    public static Collection<Street> createStreetsFromCSV()
    {
        Collection<Street> streets = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try
        {
            br = new BufferedReader(new StringReader(getStreetsString()));
            while ((line = br.readLine()) != null)
            {
                String[] streetLine = line.split(cvsSplitBy);

                String streetName = streetLine[0];
                Double streetLat =  Double.parseDouble(streetLine[1]);
                Double streetLng = Double.parseDouble(streetLine[2]);

                Street street = new Street(streetName, new LatLng(streetLat, streetLng));

                if (streetLine.length > 3)
                {
                    int i = 3;

                    while (i + 1 < streetLine.length)
                    {
                        String markerName = streetName + " " + String.valueOf((i / 2));
                        LatLng markerLatLng = new LatLng(Double.parseDouble(streetLine[i]),
                                Double.parseDouble(streetLine[i+1]));
                        street.addMarker(new Marker(markerName, markerLatLng));
                        i = i + 2;
                    }
                }

                streets.add(street);
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return streets;
    }

    private static String getStreetsString()
    {
        return new String("Abbey Lane,47.519467,-52.800441,\n" +
                "Ambassador Place,47.519467,-52.800441,\n" +
                "Amber Place,47.519467,-52.800441,\n" +
                "Arena Road,47.519467,-52.800441,\n" +
                "Armstrong Crescent,47.519467,-52.800441,\n" +
                "Ash Place,47.519467,-52.800441,\n" +
                "Ashford Drive,47.519467,-52.800441,\n" +
                "Aspenwood Place,47.519467,-52.800441,\n" +
                "Athens Drive,47.519467,-52.800441,\n" +
                "Avery Place,47.519467,-52.800441,\n" +
                "Babb Crescent,47.519467,-52.800441,\n" +
                "Badcock Place,47.519467,-52.800441,\n" +
                "Baffin Avenue,47.519467,-52.800441,\n" +
                "Baffin Drive,47.519467,-52.800441,\n" +
                "Bannister Street,47.519467,-52.800441,\n" +
                "Barbour Drive,47.519467,-52.800441,\n" +
                "Bartlett Place,47.519467,-52.800441,\n" +
                "Benson Place,47.519467,-52.800441,\n" +
                "Bettney Place,47.519467,-52.800441,\n" +
                "Billard Avenue,47.519467,-52.800441,\n" +
                "Birch Avenue,47.519467,-52.800441,\n" +
                "Blackmarsh Road,47.519467,-52.800441,\n" +
                "Blade Crescent,47.519467,-52.800441,\n" +
                "Blamey Place,47.519467,-52.800441,\n" +
                "Blandford Place,47.519467,-52.800441,\n" +
                "Bletchley Crescent,47.519467,-52.800441,\n" +
                "Blossom Avenue,47.519467,-52.800441,\n" +
                "Bonfoy Place,47.519467,-52.800441,\n" +
                "Bradley Place,47.519467,-52.800441,\n" +
                "Bragg Crescent,47.519467,-52.800441,\n" +
                "Brant Drive,47.519467,-52.800441,\n" +
                "Brett Place,47.519467,-52.800441,\n" +
                "Brodie Street,47.519467,-52.800441,\n" +
                "Burgess Avenue,47.519467,-52.800441,\n" +
                "Burrage Avenue,47.519467,-52.800441,\n" +
                "Cadiz Close,47.519467,-52.800441,\n" +
                "Carleton Drive,47.519467,-52.800441,\n" +
                "Carroll Drive,47.519467,-52.800441,\n" +
                "Castlehaven Place,47.519467,-52.800441,\n" +
                "Castors Drive,47.519467,-52.800441,\n" +
                "Chambers Cove Avenue,47.519467,-52.800441,\n" +
                "Champlain Crescent,47.519467,-52.800441,\n" +
                "Chancery Place,47.519467,-52.800441,\n" +
                "Churchill Avenue,47.519467,-52.800441,\n" +
                "Clinton Place,47.519467,-52.800441,\n" +
                "Cloverbrae Crescent,47.519467,-52.800441,\n" +
                "Cochius Lane,47.519467,-52.800441,\n" +
                "Collingwood Crescent,47.519467,-52.800441,\n" +
                "Collins Place,47.519467,-52.800441,\n" +
                "Commander Place,47.519467,-52.800441,\n" +
                "Commonwealth Avenue,47.519467,-52.800441,\n" +
                "Corte Real Place,47.519467,-52.800441,\n" +
                "Crewe Place,47.519467,-52.800441,\n" +
                "Crocker Place,47.519467,-52.800441,\n" +
                "Croucher Crescent,47.519467,-52.800441,\n" +
                "Crystal Place,47.519467,-52.800441,\n" +
                "Dalhousie Crescent,47.519467,-52.800441,\n" +
                "Dalton Avenue,47.519467,-52.800441,\n" +
                "Darby Place,47.519467,-52.800441,\n" +
                "Davis Place,47.519467,-52.800441,\n" +
                "Delaney Avenue,47.519467,-52.800441,\n" +
                "Denine Place,47.519467,-52.800441,\n" +
                "Diamond Place,47.519467,-52.800441,\n" +
                "Dollard Place,47.519467,-52.800441,\n" +
                "Donovan Street,47.519467,-52.800441,\n" +
                "Dunluce Crescent,47.519467,-52.800441,\n" +
                "Dunne's Road,47.519467,-52.800441,\n" +
                "Dunn's Lane,47.519467,-52.800441,\n" +
                "Dunrobin Street,47.519467,-52.800441,\n" +
                "Easton Place,47.519467,-52.800441,\n" +
                "Edinburgh Drive,47.519467,-52.800441,\n" +
                "Edwards Place,47.519467,-52.800441,\n" +
                "Elmcliffe Street,47.519467,-52.800441,\n" +
                "Emberley Place,47.519467,-52.800441,\n" +
                "Emerald Drive,47.519467,-52.800441,\n" +
                "Eriksson Crescent,47.519467,-52.800441,\n" +
                "Evans Place,47.519467,-52.800441,\n" +
                "Exploits Place,47.519467,-52.800441,\n" +
                "Fairweather Avenue,47.519467,-52.800441,\n" +
                "Farrell Drive,47.519467,-52.800441,\n" +
                "Finlaystone Drive,47.519467,-52.800441,\n" +
                "Firgreen Avenue,47.519467,-52.800441,\n" +
                "First Street,47.519467,-52.800441,\n" +
                "Fleet Street,47.519467,-52.800441,\n" +
                "Forest Avenue,47.519467,-52.800441,\n" +
                "Forsey Place,47.519467,-52.800441,\n" +
                "Fourth Street,47.519467,-52.800441,\n" +
                "Frobisher Avenue,47.519467,-52.800441,\n" +
                "Frontenac Avenue,47.519467,-52.800441,\n" +
                "Gadwall Place,47.519467,-52.800441,\n" +
                "Galway Crescent,47.519467,-52.800441,\n" +
                "Gates Place,47.519467,-52.800441,\n" +
                "Gibraltar Close,47.519467,-52.800441,\n" +
                "Giles Place,47.519467,-52.800441,\n" +
                "Gilham Crescent,47.519467,-52.800441,\n" +
                "Gillespie Place,47.519467,-52.800441,\n" +
                "Gillett Place,47.519467,-52.800441,\n" +
                "Glendale Avenue,47.519467,-52.800441,\n" +
                "Glendenning Place,47.519467,-52.800441,\n" +
                "Goldeneye Place,47.519467,-52.800441,\n" +
                "Gosse Place,47.519467,-52.800441,\n" +
                "Graham Place,47.519467,-52.800441,\n" +
                "Grandy Crescent,47.519467,-52.800441,\n" +
                "Greenwood Crescent,47.519467,-52.800441,\n" +
                "Grey Place,47.519467,-52.800441,\n" +
                "Groves Place,47.519467,-52.800441,\n" +
                "Gushue Avenue,47.519467,-52.800441,\n" +
                "Hagen Place,47.519467,-52.800441,\n" +
                "Halleran Place,47.519467,-52.800441,\n" +
                "Hann Place,47.519467,-52.800441,\n" +
                "Hanrahan Place,47.519467,-52.800441,\n" +
                "Harlequin Crescent,47.519467,-52.800441,\n" +
                "Harnum Crescent,47.519467,-52.800441,\n" +
                "Harvard Drive,47.519467,-52.800441,\n" +
                "Hemmer Jane Drive,47.519467,-52.800441,\n" +
                "Hillhurst Street,47.519467,-52.800441,\n" +
                "Hodder Place,47.519467,-52.800441,\n" +
                "Holden Street,47.519467,-52.800441,\n" +
                "Horatio Close,47.519467,-52.800441,\n" +
                "Hounsell Avenue,47.519467,-52.800441,\n" +
                "Hubbard Place,47.519467,-52.800441,\n" +
                "Humber Drive,47.519467,-52.800441,\n" +
                "Ingerman Street,47.519467,-52.800441,\n" +
                "Jackman Drive,47.519467,-52.800441,\n" +
                "Jacobs Place,47.519467,-52.800441,\n" +
                "Jacqueline Road,47.519467,-52.800441,\n" +
                "Jeffers Drive,47.519467,-52.800441,\n" +
                "Jeffers Place,47.519467,-52.800441,\n" +
                "Jersey Avenue,47.519467,-52.800441,\n" +
                "Jubilee Place,47.519467,-52.800441,\n" +
                "Kean Place,47.519467,-52.800441,\n" +
                "Kelburn Place,47.519467,-52.800441,\n" +
                "Kennedy Place,47.519467,-52.800441,\n" +
                "Keough Crescent,47.519467,-52.800441,\n" +
                "Lady Anne Place,47.519467,-52.800441,\n" +
                "Lancaster Crescent,47.519467,-52.800441,\n" +
                "Larsen Street,47.519467,-52.800441,\n" +
                "Lasalle Drive,47.519467,-52.800441,\n" +
                "Laumann Place,47.519467,-52.800441,\n" +
                "Laval Place,47.519467,-52.800441,\n" +
                "LeDrew Place,47.519467,-52.800441,\n" +
                "Leger Crescent,47.519467,-52.800441,\n" +
                "Lidstone Crescent,47.519467,-52.800441,\n" +
                "Lindbergh Crescent,47.519467,-52.800441,\n" +
                "Luther Place,47.519467,-52.800441,\n" +
                "MacCarthy Crescent,47.519467,-52.800441,\n" +
                "Macroom Place,47.519467,-52.800441,\n" +
                "Maisonneuve Drive,47.519467,-52.800441,\n" +
                "Manley Place,47.519467,-52.800441,\n" +
                "Maple Street,47.519467,-52.800441,\n" +
                "Marclay Avenue,47.519467,-52.800441,\n" +
                "Marconi Place,47.519467,-52.800441,\n" +
                "Marlin Drive,47.519467,-52.800441,\n" +
                "Massey Crescent,47.519467,-52.800441,\n" +
                "McCurdy Place,47.519467,-52.800441,\n" +
                "McGill Crescent,47.519467,-52.800441,\n" +
                "McGrath Crescent,47.519467,-52.800441,\n" +
                "McMaster Place,47.519467,-52.800441,\n" +
                "Medley Place,47.519467,-52.800441,\n" +
                "Michener Avenue,47.519467,-52.800441,47.521599,-52.826411, 47.518005, -52.827569,\n" +
                "Moffat Road,47.519467,-52.800441,\n" +
                "Montclair Street,47.519467,-52.800441,\n" +
                "Montgomery Avenue,47.519467,-52.800441,\n" +
                "Moores Drive,47.519467,-52.800441,\n" +
                "Mortimore Drive,47.519467,-52.800441,\n" +
                "Mount Carson Avenue,47.519467,-52.800441,\n" +
                "Mount Carson Place,47.519467,-52.800441,\n" +
                "Munden Drive,47.519467,-52.800441,\n" +
                "Municipal Avenue,47.519467,-52.800441,\n" +
                "Murley Drive,47.519467,-52.800441,\n" +
                "Muskerry Place,47.519467,-52.800441,\n" +
                "Nash Crescent,47.519467,-52.800441,\n" +
                "Neal Place,47.519467,-52.800441,\n" +
                "Nelder Drive,47.519467,-52.800441,\n" +
                "Nelson Place,47.519467,-52.800441,\n" +
                "Norman Drive,47.519467,-52.800441,\n" +
                "Norma's Avenue,47.519467,-52.800441,\n" +
                "O'Flaherty Crescent,47.519467,-52.800441,\n" +
                "O'Keefe Avenue,47.519467,-52.800441,\n" +
                "Old Placentia Road,47.519467,-52.800441,\n" +
                "Olympic Drive,47.519467,-52.800441,\n" +
                "Opal Place,47.519467,-52.800441,\n" +
                "Orchard Avenue,47.519467,-52.800441,\n" +
                "Osmond Place,47.519467,-52.800441,\n" +
                "Oxford Crescent,47.519467,-52.800441,\n" +
                "Paddon Place,47.519467,-52.800441,\n" +
                "Park Avenue,47.519467,-52.800441,\n" +
                "Parsons Avenue,47.519467,-52.800441,\n" +
                "Peckford Place,47.519467,-52.800441,\n" +
                "Pembury Close,47.519467,-52.800441,\n" +
                "Penmore Drive,47.519467,-52.800441,\n" +
                "Pike Place,47.519467,-52.800441,\n" +
                "Pinebud Crescent,47.519467,-52.800441,\n" +
                "Pinware Crescent,47.519467,-52.800441,\n" +
                "Pittman Place,47.519467,-52.800441,\n" +
                "Pleasant Avenue,47.519467,-52.800441,\n" +
                "Pollux Drive,47.519467,-52.800441,\n" +
                "Portsmouth Close,47.519467,-52.800441,\n" +
                "Princeton Crescent,47.519467,-52.800441,\n" +
                "Pumphrey Avenue,47.519467,-52.800441,\n" +
                "Putney Place,47.519467,-52.800441,\n" +
                "Relay Road,47.519467,-52.800441,\n" +
                "Rideau Place,47.519467,-52.800441,\n" +
                "Riverview Avenue,47.519467,-52.800441,\n" +
                "Rodes Place,47.519467,-52.800441,\n" +
                "Roehampton Place,47.519467,-52.800441,\n" +
                "Roland Drive,47.519467,-52.800441,\n" +
                "Roosevelt Avenue,47.519467,-52.800441,\n" +
                "Rosedale Place,47.519467,-52.800441,\n" +
                "Royal Sovereign Close,47.519467,-52.800441,\n" +
                "Ruth Avenue,47.519467,-52.800441,\n" +
                "Samson Street,47.519467,-52.800441,\n" +
                "Sandhurst Close,47.519467,-52.800441,\n" +
                "Sapphire Crescent,47.519467,-52.800441,\n" +
                "Sauve Street,47.519467,-52.800441,\n" +
                "Scammell Crescent,47.519467,-52.800441,\n" +
                "Schreyer Crescent,47.519467,-52.800441,\n" +
                "Seabright Place,47.519467,-52.800441,\n" +
                "Sears Street,47.519467,-52.800441,\n" +
                "Second Street,47.519467,-52.800441,\n" +
                "Selkirk Drive,47.519467,-52.800441,\n" +
                "Senate Crescent,47.519467,-52.800441,\n" +
                "Simcoe Drive,47.519467,-52.800441,\n" +
                "Smallwood Drive,47.519467,-52.800441,\n" +
                "Spruce Avenue,47.519467,-52.800441,\n" +
                "St. Andrew's Avenue,47.519467,-52.800441,\n" +
                "St. David's Avenue,47.519467,-52.800441,\n" +
                "Stapleton Road,47.519467,-52.800441,\n" +
                "Stojko Place,47.519467,-52.800441,\n" +
                "Stonefield Place,47.519467,-52.800441,\n" +
                "Stonegate Crescent,47.519467,-52.800441,\n" +
                "Sunrise Avenue,47.519467,-52.800441,\n" +
                "Surin Street,47.519467,-52.800441,\n" +
                "Sycamore Place,47.519467,-52.800441,\n" +
                "Talon Place,47.519467,-52.800441,\n" +
                "Tavenor Place,47.519467,-52.800441,\n" +
                "Teasdale Street,47.519467,-52.800441,\n" +
                "Thames Place,47.519467,-52.800441,\n" +
                "Third Street,47.519467,-52.800441,\n" +
                "Thomey Place,47.519467,-52.800441,\n" +
                "Toope Place,47.519467,-52.800441,\n" +
                "Topaz Place,47.519467,-52.800441,\n" +
                "Topsail Road,47.519467,-52.800441,\n" +
                "Tower Lane,47.519467,-52.800441,\n" +
                "Trafalgar Drive,47.519467,-52.800441,\n" +
                "Tricco's Road,47.519467,-52.800441,\n" +
                "Trudeau Place,47.519467,-52.800441,\n" +
                "Truxtun Place,47.519467,-52.800441,\n" +
                "Tweedsmuir Place,47.519467,-52.800441,\n" +
                "Valleyview Avenue,47.519467,-52.800441,\n" +
                "Victory Lane,47.519467,-52.800441,\n" +
                "Waterloo Crescent,47.519467,-52.800441,\n" +
                "Webb Place,47.519467,-52.800441,\n" +
                "Wellington Crescent,47.519467,-52.800441,\n" +
                "Wells Crescent,47.519467,-52.800441,\n" +
                "Wembley Crescent,47.519467,-52.800441,\n" +
                "Westbrook Landing,47.519467,-52.800441,\n" +
                "Westminster Drive,47.519467,-52.800441,\n" +
                "Whelan Avenue,47.519467,-52.800441,\n" +
                "White Place,47.519467,-52.800441,\n" +
                "Whitehall Place,47.519467,-52.800441,\n" +
                "Whiteley Drive,47.519467,-52.800441,\n" +
                "Wilchris Place,47.519467,-52.800441,\n" +
                "Wilcox Place,47.519467,-52.800441,\n" +
                "Wilkes Avenue,47.519467,-52.800441,\n" +
                "Wilson Crescent,47.519467,-52.800441,\n" +
                "Winsor Place,47.519467,-52.800441,\n" +
                "Winston Avenue,47.519467,-52.800441,\n" +
                "Woodford Drive,47.519467,-52.800441,\n" +
                "Woodford Place,47.519467,-52.800441,\n" +
                "Worral Crescent,47.519467,-52.800441,\n" +
                "Wyatt Boulevard,47.519467,-52.800441,\n" +
                "Yale Place,47.519467,-52.800441,\n" +
                "Yetman Drive,47.519467,-52.800441");
    }


}
