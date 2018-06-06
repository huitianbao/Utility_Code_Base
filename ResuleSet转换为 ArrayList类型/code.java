public ArrayList<SendDynamicEntity> getList() {
        try {
            ArrayList<SendDynamicEntity> al = new ArrayList<>();
            ConnectionFactory cf = ConnectionFactory.getInstance();
            Connection connection = cf.makeConnection();
            
            
            SendDynamicImpl sendDynamicImpl = new SendDynamicImpl();
            
            ResultSet resultSet = sendDynamicImpl.quarrayAll_ResultSet(connection);
            while(resultSet.next()){
                SendDynamicEntity sendDynamicEntity = new SendDynamicEntity();
                sendDynamicEntity.setUid(resultSet.getString("uid"));
                sendDynamicEntity.setDid(resultSet.getString("did"));
                sendDynamicEntity.setContent(resultSet.getString("content"));
                sendDynamicEntity.setTitle(resultSet.getString("title"));
                sendDynamicEntity.setPhoto(resultSet.getString("photo"));
                sendDynamicEntity.setDate(resultSet.getString("date"));
                
                al.add(sendDynamicEntity);
                
            }
            
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(SendDynamicImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }