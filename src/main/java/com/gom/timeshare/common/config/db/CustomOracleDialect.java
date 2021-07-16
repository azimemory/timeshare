package com.gom.timeshare.common.config.db;

import org.hibernate.dialect.Oracle10gDialect;

/**
 * @author 하명도
 * @apiNote hibernate의 Oracle10gDialect 사용시 데이터베이스의 시퀀스를 가져오지 못하는 문제 해결
 *          number-overflow를 처리하기 위해  sequence의 최대값을 long 최대값 크기로 설정 *
 */
public class CustomOracleDialect extends Oracle10gDialect {
    @Override
    public String getQuerySequencesString() {
        return "select SEQUENCE_OWNER, SEQUENCE_NAME, greatest(MIN_VALUE,         -9223372036854775807) MIN_VALUE,\n"+
                "Least(MAX_VALUE, 9223372036854775808) MAX_VALUE, INCREMENT_BY,     CYCLE_FLAG, ORDER_FLAG, CACHE_SIZE,\n"+
                "Least(greatest(LAST_NUMBER, -9223372036854775807), 9223372036854775808) LAST_NUMBER\n"+
                "from all_sequences";
    }
}
