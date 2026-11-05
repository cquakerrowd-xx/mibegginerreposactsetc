public class IncidentRecord {
    private static int idCounter = 1;
    private int incidentId;
    private String farmerName;
    private String threatName;
    private String location;
    private String probableCause;
    private String status; 

    public IncidentRecord(String farmerName, String threatName, String location, String probableCause) {
        this.incidentId = idCounter++;
        this.farmerName = farmerName;
        this.threatName = threatName;
        this.location = location;
        this.probableCause = probableCause;
        this.status = "Pending";
    }

    public int getIncidentId() { 
    	return incidentId; 
    	}
    
    public String getFarmerName() { 
    	return farmerName; 
    	}
    public void setFarmerName(String farmerName) { 
    	this.farmerName = farmerName; 
    	}
    
    public String getThreatName() { 
    	return threatName; 
    	}
    public void setThreatName(String threatName) { 
    	this.threatName = threatName; 
    	}
    
    public String getLocation() { 
    	return location; 
    	}
    public void setLocation(String location) { 
    	this.location = location; 
    	}
    
    public String getProbableCause() { 
    	return probableCause; 
    	}
    public void setProbableCause(String probableCause) { 
    	this.probableCause = probableCause; 
    	}
    
    public String getStatus() { 
    	return status; 
    	}
    public void setStatus(String status) { 
    	this.status = status; 
    	}
}