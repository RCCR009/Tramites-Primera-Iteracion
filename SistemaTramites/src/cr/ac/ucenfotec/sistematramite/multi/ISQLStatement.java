package cr.ac.ucenfotec.sistematramite.multi;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import java.util.ArrayList;

public interface ISQLStatement {
	
        void GetCreateStatement(BaseEntity entity) throws Exception;
        ArrayList<BaseEntity> GetRetriveAllStatement() throws Exception;
        BaseEntity GetRetriveStatement(BaseEntity entity) throws Exception;
        void GetUpdateStatement(BaseEntity entity) throws Exception;
        void GetDeleteStatement(BaseEntity entity) throws Exception;  
}
