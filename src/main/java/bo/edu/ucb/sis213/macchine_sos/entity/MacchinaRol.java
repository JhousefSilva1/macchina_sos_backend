package bo.edu.ucb.sis213.macchine_sos.entity;

import java.util.Date;

public class MacchinaRol {

    private Integer rolId;
    private String named;
    private String description;
    private Boolean status;
    private String txUsername;
    private String txHost;
    private Date txDate;

    public MacchinaRol() {
    }

    public MacchinaRol(Integer rolId, String named, String description, Boolean status, String txUsername, String txHost, Date txDate) {
        this.rolId = rolId;
        this.named = named;
        this.description = description;
        this.status = status;
        this.txUsername = txUsername;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getNamed() {
        return named;
    }

    public void setNamed(String named) {
        this.named = named;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTxUsername() {
        return txUsername;
    }

    public void setTxUsername(String txUsername) {
        this.txUsername = txUsername;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "MacchinaRol{" +
                "rolId=" + rolId +
                ", named='" + named + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", txUsername='" + txUsername + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
